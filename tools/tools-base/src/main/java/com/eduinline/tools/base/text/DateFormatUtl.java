package com.eduinline.tools.base.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>com.helizfamily.tools.base.text.DateFormatUtl.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月7日-上午8:52:37
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 处理日期格式化的工具类 <br> 
 * <strong>字母  日期或时间元素  表示  示例</strong> <br> 
 * 	G  Era 标志符  Text  AD   <br> 
 * 	y  年  Year  1996; 96   <br> 
 * 	M  年中的月份  Month  July; Jul; 07  <br>  
 * 	w  年中的周数  Number  27   <br> 
 * 	W  月份中的周数  Number  2   <br> 
 * 	D  年中的天数  Number  189   <br> 
 * 	d  月份中的天数  Number  10   <br> 
 * 	F  月份中的星期  Number  2   <br> 
 * 	E  星期中的天数  Text  Tuesday; Tue   <br> 
 * 	a  Am/pm 标记  Text  PM   <br> 
 * 	H  一天中的小时数（0-23）  Number  0   <br> 
 * 	k  一天中的小时数（1-24）  Number  24   <br> 
 * 	K  am/pm 中的小时数（0-11）  Number  0   <br> 
 * 	h  am/pm 中的小时数（1-12）  Number  12   <br> 
 * 	m  小时中的分钟数  Number  30   <br> 
 * 	s  分钟中的秒数  Number  55   <br> 
 * 	S  毫秒数  Number  978   <br> 
 * 	z  时区  General time zone  Pacific Standard Time; PST; GMT-08:00  <br>  
 * 	Z  时区  RFC 822 time zone  -0800   <br> 
 */
public class DateFormatUtl {
	
	/**
	 * 根据指定的模式格式化日期。SimpleDateFormat非线程安全，所以new
	 * @param pattern 日期模式
	 * @param obj 需要格式化的对象
	 * @return 格式化的日期字符串
	 */
	public static String format(String pattern, Object obj){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(obj);
	}
	
	/**
	 * 根据指定的模式解析日期字符。SimpleDateFormat非线程安全，所以new
	 * @param pattern 日期模式
	 * @param source 需要解析的日期字符串
	 * @return Date 日期对象
	 * @throws ParseException
	 */
	public static Date parse(String pattern, String source) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(source);
	}
	
}

