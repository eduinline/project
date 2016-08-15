package com.eduinline.tools.base.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <p>异常信息处理类</p>
 *
 * @author hongze.he@eduinline.com
 * @version 1.0 2016年4月25日-下午8:37:24
 */
public class ServiceException extends RuntimeException {
	
	/** 序列化版本ID */
	private static final long serialVersionUID = -5859073215543430631L;
	
	/** 异常代码 */
	protected String errorCode;
	
	/** 异常信息 */
	protected String message;
	
	/** 参数 */
	protected Object[] params;
	
	/** 序列化版本ID */
	protected Exception originException;

	public ServiceException() {
		super();
	}

	public ServiceException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}
	
	public ServiceException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
		this.message = message;
	}

	public ServiceException(String errorCode, String message, Object... params) {
		super(message);
		this.errorCode = errorCode;
		this.message = message;
		this.params = params;
	}

	public ServiceException(String errorCode, Exception originException) {
		super(errorCode);
		this.errorCode = errorCode;
		this.originException = originException;
	}
	
	public ServiceException(String errorCode, String message, Exception originException) {
		super(message);
		this.errorCode = errorCode;
		this.message = message;
		this.originException = originException;
	}
	
	public ServiceException(String errorCode, String message, 
			Exception originException, Object... params) {
		super(message);
		this.errorCode = errorCode;
		this.message = message;
		this.params = params;
	}
	
	/**
	 * <p>获取异常详细信息</p>
	 * @return 异常详细信息
	 */
	public String getOriginExceptionInfo() {
		if(null==getOriginException())
			return "";
		StringWriter stringWriter = new StringWriter();
		getOriginException().printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public Exception getOriginException() {
		return originException;
	}

	public void setOriginException(Exception originException) {
		this.originException = originException;
	}
	
}
