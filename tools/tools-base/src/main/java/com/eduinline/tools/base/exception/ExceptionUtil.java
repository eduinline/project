package com.eduinline.tools.base.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <p>异常处理工具类</p>
 *
 * @author hongze.he@eduinline.com
 * @version 1.0 2016年4月25日-下午8:37:24
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
