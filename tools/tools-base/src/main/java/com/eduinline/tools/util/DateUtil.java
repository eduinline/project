package com.eduinline.tools.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>com.helizfamily.tools.base.date.DateUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月18日-上午9:55:13
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 日期处理工具类
 */
public class DateUtil {
	
	protected static final String DATE_FORMAT = "yyyy-MM-dd";
	protected static final String TIME_FORMAT = "HH:mm:ss";
	protected static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm";
	protected static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	protected static final String DATE_T_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
	protected static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	
	protected static final String dayOfWeekNames[] = 
		{ "星期六", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五" };

	/**
	 * 格式化日期为yyyy-MM-dd
	 * @param obj 需要格式化的对象
	 * @return 格式化的日期字符串
	 */
	public static String format4yyyyMMdd(Object obj){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(obj);
	}
	
	/**
	 * 格式化日期为HH:mm:ss
	 * @param obj 需要格式化的对象
	 * @return 格式化的日期字符串
	 */
	public static String format4HHmmss(Object obj){
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
		return sdf.format(obj);
	}
	
	/**
	 * 格式化日期为yyyy-MM-dd HH:mm
	 * @param obj 需要格式化的对象
	 * @return 格式化的日期字符串
	 */
	public static String format4yyyyMMddHHmm(Object obj){
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
		return sdf.format(obj);
	}
	
	/**
	 * 格式化日期为yyyy-MM-dd HH:mm:ss
	 * @param obj 需要格式化的对象
	 * @return 格式化的日期字符串
	 */
	public static String format4yyyyMMddHHmmss(Object obj){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
		return sdf.format(obj);
	}
	
	/**
	 * 格式化日期为yyyy-MM-dd'T'HH:mm:ss
	 * @param obj 需要格式化的对象
	 * @return 格式化的日期字符串
	 */
	public static String format4yyyyMMddTHHmmss(Object obj){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_T_TIME_FORMAT);
		return sdf.format(obj);
	}
	
	/**
	 * 格式化日期为yyyy-MM-dd HH:mm:ss.S
	 * @param obj 需要格式化的对象
	 * @return 格式化的日期字符串
	 */
	public static String format4yyyyMMddHHmmssS(Object obj){
		SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP_FORMAT);
		return sdf.format(obj);
	}
	
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
		SimpleDateFormat.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(source);
	}
	
	/**
	 * <p>对当前日期进行操作</p>
	 * @param date 当前日期
	 * @param field 操作的区域：Calendar.xxx常量
	 * @param amount 操作的区域值：整数则加；负数则减
	 * @return 操作后的日期
	 */
	public static Date handleDate(Date date, int field, int amount){
		Calendar result = Calendar.getInstance();
		result.setTime(date);
		result.add(field, amount);
		return result.getTime();
	}
	
	/**
	 * compareDate(比较2个日期大小)
	 * @param date1 日期1
	 * @param date2 日期2
	 * @return -1:日期1<日期2；1:日期1>日期2；0:日期1=日期2
	 */
	public static int compareDate(Date date1, Date date2) {
		if (date1.before(date2)) {
			return -1;
		} else if (date1.after(date2)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * getChineseWeek(获取当前日期的星期名称)
	 * @param date 当前日期
	 * @return 星期几
	 */
	public static String getChineseWeek(Date date) {
		Calendar result = Calendar.getInstance();
		result.setTime(date);
		int dayOfWeek = result.get(Calendar.DAY_OF_WEEK);
		return dayOfWeekNames[dayOfWeek];
	}
	
	/**
	 * elapsedTime(计算2个日期的耗时)
	 * @param date1 日期1
	 * @param date2 日期2
	 * @return 耗时时间 HH:mm:ss
	 * @throws ParseException
	 */
	public static String elapsedTime(Date date1, Date date2) throws ParseException{
		if(null==date1 || null==date2)
			return "";
		
		if(date1.after(date2)){
			Date temp = date1;
			date1 = date2;
			date2 = temp;
		}
		
		long elapsedTime = date2.getTime()-date1.getTime();
		String tempDateStr = format(DATE_FORMAT, date1);
		Date temp = parse(tempDateStr, DATE_FORMAT);
		Date date = new Date(temp.getTime()+elapsedTime);
		
		return format(TIME_FORMAT, date);
	}
	
	/**
	 * <p>比较2个日期段是否有交集</p>
	 * @param begin1 第一个日期段的开始时间
	 * @param end1 第一个日期段的结束时间
	 * @param begin2 第二个日期段的开始时间
	 * @param end2 第二个日期段的结束时间
	 * @return true=存在交集；false不存在交集
	 */
	public static boolean checkDateUnion(Date begin1, Date end1, 
			Date begin2, Date end2){
		if(begin1.after(end2) || end1.before(begin2)){
			return false;
		}else{
			return true;
		}
	}
	
}

