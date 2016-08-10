/**
 * tools-validate
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年8月10日-上午9:24:18]
 * 
 */
package com.eduinline.tools.validate;

import java.util.Map;

/**
 * <p>Hibernate Validate 校验结果</p>
 * 
 * @version 1.0 2016年8月10日-上午9:24:18
 * @author hongze.he@eduinline.com
 */
public class ValidationResult {
	//校验结果是否有错
	private boolean hasErrors;

	//校验错误信息
	private Map<String,String> errorMsg;

	public boolean isHasErrors() {
		return hasErrors;
	}

	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}

	public Map<String, String> getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(Map<String, String> errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "ValidationResult [hasErrors=" + hasErrors + ", errorMsg="
				+ errorMsg + "]";
	}
}
