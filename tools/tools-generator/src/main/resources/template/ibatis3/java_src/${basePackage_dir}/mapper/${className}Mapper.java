<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package com.airsky.usp.repository.${oneDomain}.${twoDomain};

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.airsky.usp.entities.${oneDomain}.${twoDomain}.${className};
import com.airsky.usp.entities.system.menus.Menus;

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
	
	/**
	 * 新增多语言处理
	 * @param m 需要处理的对象
	 */
	void insertLanguage(@Param("m")${className} m);
	
	/**
	 * 更新多语言处理
	 * @param m 需要处理的对象
	 */
	void updateLanguage(@Param("m")${className} m);
	
	/**
	 * 删除多语言处理
	 * @param id 主表ID
	 */
	void deleteLanguage(${table.idColumn.javaType} id);
	
}