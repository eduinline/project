<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package com.airsky.usp.service.impl.${oneDomain}.${twoDomain};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airsky.usp.entities.${oneDomain}.${twoDomain}.${className};
import com.airsky.usp.repository.${oneDomain}.${twoDomain}.${className}Mapper;
import com.airsky.usp.service.${oneDomain}.${twoDomain}.I${className}Service;
import com.framework.service.base.impl.CrudServiceImpl;

@Service
public class ${className}ServiceImpl extends CrudServiceImpl<${className}, ${table.idColumn.javaType}> 
implements I${className}Service {
	
	@Autowired
	private ${className}Mapper ${classNameLower}Mapper;

	@Override
	public void batchDelete(List<${table.idColumn.javaType}> ids) {
		${classNameLower}Mapper.batchDelete(ids);
	}
	
	@Override
	public boolean checkUnique(${className} m) {
		List<${className}> list = ${classNameLower}Mapper.checkUnique(m);
		if(list.isEmpty())
			return true;
		return false;
	}
	
}
