<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package com.airsky.usp.service.${oneDomain}.${twoDomain};

import java.util.List;

import com.airsky.usp.entities.${oneDomain}.${twoDomain}.${className};
import com.airsky.usp.entities.system.menus.Menus;
import com.framework.service.base.ICrudService;

public interface I${className}Service extends ICrudService<${className}, ${table.idColumn.javaType}>{
	
	/**
	 * 批量删除
	 */
	void batchDelete(List<${table.idColumn.javaType}> ids);
	
	/**
	 * <p>检查是否唯一</p>
	 * @param m 校验对象
	 * @return true=唯一；false=不唯一
	 */
	boolean checkUnique(${className} m);
	
	/**
	 * 新增多语言处理
	 * @param m 需要处理的对象
	 */
	void insertLanguage(${className} m);
	
	/**
	 * 更新多语言处理
	 * @param m 需要处理的对象
	 */
	void updateLanguage(${className} m);
	
	/**
	 * 删除多语言处理
	 * @param id 主表ID
	 */
	void deleteLanguage(${table.idColumn.javaType} id);
	
}
