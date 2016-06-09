<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basePackage}.controller.${oneDomain}.${twoDomain}.errorcode;

public interface I${className}ControllerError {
	
	/**
	 * 运行时--保存操作--错误代码
	 */
	String SAVE_ERR_CODE_RUNTITME = "${errorBase}1";
	/**
	 * 运行时--修改操作--错误代码
	 */
	String UPDATE_ERR_CODE_RUNTITME = "${errorBase}2";
	/**
	 * 运行时--删除操作--错误代码
	 */
	String DELETE_ERR_CODE_RUNTITME = "${errorBase}3";
	/**
	 * 运行时--查询操作--错误代码
	 */
	String SEARCH_ERR_CODE_RUNTITME = "${errorBase}4";

}
