package com.eduinline.tools.base.lang;

/**
 * <p>com.helizfamily.tools.base.str.StrUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月18日-上午9:49:50
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 字符串操作工具类
 */
public class StrUtil {
	
	/**
	 * isBlank(判断字符串是否为空)
	 * @param target 待判断的字符串
	 * @return null或者""则返回true
	 */
	public static boolean isBlank(String target){
		if(null==target)
			return true;
		else if("".equals(target.trim()))
			return true;
		return false;
	}
	
	/**
	 * 判断字符不为空
	 * @param target 待判断的字符串
	 * @return true=不为空
	 */
	public static boolean isNotBlank(String target){
		return !isBlank(target);
	}
	
	/**
	 * format(Java中使用%作为占位符,该方法会使用提供的参数替换占位符)
	 * Java中字符串的占位符如下：
	 * %s 字符串类型
	 * %c 字符类型
	 * %b 布尔类型
	 * %d 整数类型（十进制）
	 * %x 整数类型（十六进制）
	 * %o 整数类型（八进制）
	 * %f 浮点类型
	 * %a 十六进制浮点类型
	 * %e 指数类型
	 * %g 通用浮点类型（f和e类型中较短的）
	 * %h 散列码
	 * %% 百分比类型
	 * %n 换行符
	 * %tx 日期与时间类型(x代表不同的日期与时间转换符,如%tY-%tm-%td %tH:%tM:%tS)
	 * @param format 需要格式化的字符串。如: my name is %s. 则%s就是占位符
	 * @param args 替换占位符的参数
	 * @return 格式化后的字符串
	 */
	public static String format(String format, Object... args){
		return String.format(format, args);
	}
	
}

