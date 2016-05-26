<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package com.airsky.usp.${oneDomain}.service.${twoDomain}.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airsky.usp.common.service.base.impl.CrudServiceImpl;
import com.airsky.usp.${oneDomain}.entities.${twoDomain}.${className};
import com.airsky.usp.${oneDomain}.repository.${twoDomain}.${className}Mapper;
import com.airsky.usp.${oneDomain}.service.${twoDomain}.I${className}Service;

@Service
public class ${className}ServiceImpl extends CrudServiceImpl<${className}, ${table.idColumn.javaType}> 
implements I${className}Service {
	
	@Autowired
	private ${className}Mapper ${classNameLower}Mapper;

	@Override
	public void batchDelete(List<${table.idColumn.javaType}> ids) {
		${classNameLower}Mapper.batchDelete(ids);
	}
	
}
