<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package com.airsky.usp.service.impl.${oneDomain}.${twoDomain};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airsky.usp.entities.${oneDomain}.${twoDomain}.${className};
import com.airsky.usp.repository.${oneDomain}.${twoDomain}.${className}Mapper;
import com.airsky.usp.service.${oneDomain}.${twoDomain}.I${className}Service;
import com.framework.dto.language.MulLanDto;
import com.framework.dto.language.MulLanModel;
import com.framework.service.base.impl.CrudServiceImpl;

@Service
public class ${className}ServiceImpl extends CrudServiceImpl<${className}, ${table.idColumn.javaType}> 
implements I${className}Service {
	
	@Autowired
	private ${className}Mapper ${classNameLower}Mapper;

	@Override
	public void batchDelete(List<${table.idColumn.javaType}> ids) {
		<#if mulLanguage=='Y'>
		for (${table.idColumn.javaType} id : ids) {
			${classNameLower}Mapper.deleteLanguage(id);
		}
		</#if>
		${classNameLower}Mapper.batchDelete(ids);
	}
	
	@Override
	public boolean checkUnique(${className} m) {
		List<${className}> list = ${classNameLower}Mapper.checkUnique(m);
		if(list.isEmpty())
			return true;
		return false;
	}
	
	@Override
	public void afterSave(${className} entity, ${table.idColumn.javaType} id){
		entity.setId(id);
		${classNameLower}Mapper.insertLanguage(entity, entity.getLanCode());
	}
	
	@Override
	public void afterUpdate(${className} entity){
		${classNameLower}Mapper.updateLanguage(entity);
	}
	
	@Override
	public boolean beforeDelete(${table.idColumn.javaType} id){
		${classNameLower}Mapper.deleteLanguage(id);
		return true;
	}
	
	@Override
	public void insertLanguage(${className} m, String lanCode) {
		${classNameLower}Mapper.insertLanguage(m, lanCode);
	}

	@Override
	public List<MulLanDto> findMulLanById(${table.idColumn.javaType} id, String field) {
		return ${classNameLower}Mapper.findMulLanById(id, field);
	}

	@Override
	public void upadteMulLan(MulLanModel mulLanModel) {
		List<MulLanDto> mulLanList = mulLanModel.getMulLanList();
		for (MulLanDto mulLanDto : mulLanList) {
			${classNameLower}Mapper.upadteMulLan(mulLanDto);
		}
	}
	
}
