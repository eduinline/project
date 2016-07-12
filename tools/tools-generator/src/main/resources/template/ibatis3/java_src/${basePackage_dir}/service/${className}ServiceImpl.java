<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basePackage}.service.impl.${oneDomain}.${twoDomain};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${basePackage}.entities.${oneDomain}.${twoDomain}.${className};
import ${basePackage}.repository.${oneDomain}.${twoDomain}.${className}Mapper;
import ${basePackage}.service.${oneDomain}.${twoDomain}.I${className}Service;
import com.framework.common.exception.ServiceException;
import ${basePackage}.dto.mullan.MulLanDto;
import ${basePackage}.dto.mullan.MulLanModel;
import com.framework.service.base.impl.CrudServiceImpl;

@Service
public class ${className}ServiceImpl extends CrudServiceImpl<${className}, ${table.idColumn.javaType}> 
implements I${className}Service {
	
	@Autowired
	private ${className}Mapper ${classNameLower}Mapper;
	
	@Override
	public boolean beforeSave(${className} entity){
		if(!checkUnique(entity))
			throw new ServiceException("已存在");
		return true;
	}
	
	@Override
	public boolean beforeUpdate(${className} entity){
		if (!checkUnique(entity))
			throw new ServiceException("已存在");
		return true;
	}

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
