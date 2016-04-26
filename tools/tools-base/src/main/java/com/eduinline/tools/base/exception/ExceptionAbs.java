package com.eduinline.tools.base.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>异常信息处理抽象类，有自定义异常类则继承此抽象类</p>
 *
 * @author hongze.he@eduinline.com
 * @version 1.0 2016年4月25日-下午8:37:24
 */
public abstract class ExceptionAbs extends Exception {
	
	private static final long serialVersionUID = 7659905943361817995L;
	
	/** 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/** 异常信息 */
	private String message;

	/**
	 * 默认构造函数
	 */
	public ExceptionAbs() {
		super();
	}

	/**
	 * 构造函数
	 * @param message 提示信息
	 */
	public ExceptionAbs(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * 构造函数
	 * @param message 提示信息
	 * @param cause 异常实例
	 */
	public ExceptionAbs(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	/**
	 * 构造函数 
	 * @param cause 异常实例
	 */
	public ExceptionAbs(Throwable cause) {
		super(cause);
	}

	/**
	 * 构造函数 
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	protected ExceptionAbs(String message, Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message;
	}

	/**
	 * getMessageForUser(抽象方法，用于子类返回用户看的信息)
	 * @return
	 */
	public abstract String getMessageForUser();

	/*
	 * 重写父类方法，message为null时返回默认的用户提示信息
	 * @return
	 * @see java.lang.Throwable#getLocalizedMessage()
	 */
	public String getLocalizedMessage(){
		if(null==message || "null".equals(message) || "".equals(message))
			return getMessageForUser();
		else
			return message;
	}

	/*
	 * 重写父类方法，返回具体的StackTrace
	 * @return
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage(){
		StringWriter stringWriter = new StringWriter();
		this.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

}
