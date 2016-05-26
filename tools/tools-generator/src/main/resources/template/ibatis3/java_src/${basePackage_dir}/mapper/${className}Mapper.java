<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package com.airsky.usp.${oneDomain}.repository.${twoDomain};

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ${className}Mapper {
	
	void batchDelete(@Param("ids")List<${table.idColumn.javaType}> ids);
	
}