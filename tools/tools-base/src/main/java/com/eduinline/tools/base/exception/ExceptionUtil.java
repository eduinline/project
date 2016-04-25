package com.eduinline.tools.base.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <p>com.hezliz.tools.base.exception.ExceptionUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月1日-下午2:14:35
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 异常工具类
 */
public class ExceptionUtil {

	/**
	 * getStackTraceInfo(获取异常ErrorStack)
	 * @param ex 异常对象
	 * @return
	 */
	public static String getStackTraceInfo(Throwable ex) {
		StringWriter stringWriter = new StringWriter();
		ex.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

}
