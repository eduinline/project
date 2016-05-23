<#include "/java_copyright.include">
<#assign className = table.className>   
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package com.csair.fms.services.easyfare.impl;

import org.springframework.stereotype.Service;

import ${packagePath}.${className};
import com.csair.fms.services.base.impl.CrudServiceImpl4atpco;
import com.csair.fms.services.easyfare.${className}Service;

@Service
public class ${className}ServiceImpl extends CrudServiceImpl4atpco<${className},${table.idColumn.javaType}> implements
	${className}Service{
	
}
