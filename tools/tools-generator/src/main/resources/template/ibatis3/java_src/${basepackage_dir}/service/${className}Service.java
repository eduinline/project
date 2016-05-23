<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package com.csair.fms.services.easyfare;

import ${packagePath}.${className};

import com.csair.fms.repository.atpco.entities.easyfare.${className};
import com.csair.fms.services.base.ICrudService;

/**
 * <p>com.csair.fms.services.easyfare.${className}Service.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年4月11日-下午3:42:21
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose EasyFare导出功能业务接口
 */
public interface ${className}Service extends ICrudService<${className}, ${table.idColumn.javaType}>{
	
}
