<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package com.airsky.usp.repository.${oneDomain}.${twoDomain};

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.airsky.usp.entities.${oneDomain}.${twoDomain}.${className};

public interface ${className}Mapper {
	
	/**
	 * 批量删除
	 * @param ids 需要删除的记录主机集合
	 */
	void batchDelete(@Param("ids")List<${table.idColumn.javaType}> ids);
	
	/**
	 * <p>校验唯一性</p>
	 * @param m 需要检验的对象
	 * @return List<${className}>
	 */
	List<${className}> checkUnique(@Param("m")${className} m);
	
}