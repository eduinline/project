<#include "/macro.include"/>
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package com.airsky.usp.entities.${oneDomain}.${twoDomain};

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.framework.common.entities.BaseEntity;
import com.framework.common.util.DateConvertUtils;

public class ${className} extends BaseEntity implements java.io.Serializable{

	private static final long serialVersionUID = 5454155825314635342L;

	//属性注释，如：ALIAS_JMQ_TOPIC_ID = "主题ID";
	public static final String TABLE_NAME = "${table.tableAlias}";
	<#list table.columns as column>
	public static final String ALIAS_${column.constantName} = "${column.columnAlias}";
	</#list>

	//date formats
	<#list table.columns as column>
	<#if column.isDateTimeColumn>
	public static final String FORMAT_${column.constantName} = DATE_TIME_FORMAT;
	</#if>
	</#list>

	//the column is a primary key	
	<#if table.pkCount==1>
	<#list table.pkColumns as column>	
	public static final String PROP_KEY = "${column.columnNameLower}";
	</#list>
	</#if>



	//fields START
	public static String PROP_REF="${className}";

	<#list table.columns as column>
	<#if column.isDateTimeColumn>
	public static String PROP_REF_${column.constantName}_BEGIN = "${column.columnNameFirstLower}Begin";

	public static String PROP_REF_${column.constantName}_END = "${column.columnNameFirstLower}End";
	<#else>
	public static String PROP_REF_${column.constantName} = "${column.columnNameLower}";
	</#if>

	</#list>
	//fields END

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	<#list table.columns as column>
	<#if column.isDateTimeColumn>
	private ${column.javaType} ${column.columnNameLower};
	private ${column.javaType} ${column.columnNameLower}Begin;
	private ${column.javaType} ${column.columnNameLower}End;
	<#else>
	private ${column.javaType} ${column.columnNameLower};
	</#if>
	</#list>
	//columns END

	<@generateConstructor className/>
	<@generateJavaColumns/>
	<@generateJavaOneToMany/>
	<@generateJavaManyToOne/>
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		<#list table.columns as column>
		.append("${column.columnName}",get${column.columnName}())
		</#list>
		.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
		<#list table.pkColumns as column>
		.append(get${column.columnName}())
		</#list>
		.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof ${className} == false) return false;
		if(this == obj) return true;
		${className} other = (${className})obj;
		return new EqualsBuilder()
		<#list table.pkColumns as column>
		.append(get${column.columnName}(),other.get${column.columnName}())
		</#list>
		.isEquals();
	}
}

<#macro generateJavaColumns>
<#list table.columns as column>
<#if column.isDateTimeColumn>
public String get${column.columnName}String() {
	return DateConvertUtils.format(get${column.columnName}(), FORMAT_${column.constantName});
}
public void set${column.columnName}String(String value) {
	set${column.columnName}(DateConvertUtils.parse(value, FORMAT_${column.constantName},${column.javaType}.class));
}
public void set${column.columnName}Begin(${column.javaType} value) {
	this.${column.columnNameLower}Begin = value;
}
public ${column.javaType} get${column.columnName}Begin() {
	return this.${column.columnNameLower}Begin;
}
public void set${column.columnName}End(${column.javaType} value) {
	this.${column.columnNameLower}End = value;
}
public ${column.javaType} get${column.columnName}End() {
	return this.${column.columnNameLower}End;
}
</#if>	
public void set${column.columnName}(${column.javaType} value) {
	this.${column.columnNameLower} = value;
}

public ${column.javaType} get${column.columnName}() {
	return this.${column.columnNameLower};
}
</#list>
</#macro>

<#macro generateJavaOneToMany>
<#list table.exportedKeys.associatedTables?values as foreignKey>
<#assign fkSqlTable = foreignKey.sqlTable>
<#assign fkTable    = fkSqlTable.className>
<#assign fkPojoClass = fkSqlTable.className>
<#assign fkPojoClassVar = fkPojoClass?uncap_first>

private Set ${fkPojoClassVar}s = new HashSet(0);
public void set${fkPojoClass}s(Set<${fkPojoClass}> ${fkPojoClassVar}){
	this.${fkPojoClassVar}s = ${fkPojoClassVar};
}

public Set<${fkPojoClass}> get${fkPojoClass}s() {
	return ${fkPojoClassVar}s;
}
</#list>
</#macro>

<#macro generateJavaManyToOne>
<#list table.importedKeys.associatedTables?values as foreignKey>
<#assign fkSqlTable = foreignKey.sqlTable>
<#assign fkTable    = fkSqlTable.className>
<#assign fkPojoClass = fkSqlTable.className>
<#assign fkPojoClassVar = fkPojoClass?uncap_first>

private ${fkPojoClass} ${fkPojoClassVar};

public void set${fkPojoClass}(${fkPojoClass} ${fkPojoClassVar}){
	this.${fkPojoClassVar} = ${fkPojoClassVar};
}

public ${fkPojoClass} get${fkPojoClass}() {
	return ${fkPojoClassVar};
}
</#list>
</#macro>
