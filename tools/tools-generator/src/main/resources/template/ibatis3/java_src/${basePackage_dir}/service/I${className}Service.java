<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package com.airsky.usp.${oneDomain}.service.${twoDomain};

import java.util.List;

import com.airsky.usp.common.service.base.ICrudService;
import com.airsky.usp.${oneDomain}.entities.${twoDomain}.${className};

public interface I${className}Service extends ICrudService<${className}, ${table.idColumn.javaType}>{
	/**
	 * 批量删除
	 */
	void batchDelete(List<${table.idColumn.javaType}> ids);
	
}
