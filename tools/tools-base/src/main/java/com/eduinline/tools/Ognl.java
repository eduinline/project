package com.eduinline.tools;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>最基础的OGNL工具类，提供最基本Java对象处理方法</p>
 *
 * @author hongze.he@eduinline.com
 * @version 1.0 2016年4月26日-上午7:20:39
 */
public class Ognl {

	/**
	 * 判断 Map,Collection,String,Array是否为空
	 * @param obj 需要判断的对象
	 * @return TRUE=为空；FALSE=不为空；null=为空
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj){
		if(null==obj) 
			return true;
		if(obj instanceof String) {
			return ((String)obj).length() == 0;
		}else if(obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		}else if(obj instanceof Collection) {
			return ((Collection)obj).isEmpty();
		}else if(obj instanceof Map) {
			return ((Map)obj).isEmpty();
		}else {
			return false;
		}
	}
	
	/**
	 * 判断 Map,Collection,String,Array是否<B>不</B>为空
	 * @param obj 待判断的对象
	 * @return TRUE=不为空，否则为空
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
	
	/**
	 * 判断 多个Map,Collection,String,Array是否<B>不</B>为空
	 * @param obj 待判断的对象
	 * @return TRUE=不为空，否则为空
	 */
	public static boolean isNotEmpty(Object... obj) {
		for(int i=0; i<obj.length; i++){
			boolean currentNotEmpty = isNotEmpty(obj);
			if(!currentNotEmpty){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断2个对象是否相等
	 * @param o1 对象1
	 * @param o2 对象2
	 * @return TRUE=相等，否则不相等
	 */
	public static boolean isEquals(Object o1,Object o2) {
		if(null==o1 && null==o2)
			return false;
		if(null!=o1)
			return o1.equals(o2);
		return o2.equals(o1);
	}
	
	/**
	 * 判断2个对象是否<B>不</B>相等
	 * @param o1 对象1
	 * @param o2 对象2
	 * @return TRUE=不相等，否则相等
	 */
	public static boolean isNotEquals(Object o1,Object o2) {
		return !isEquals(o1, o2);
	}
	
	/**
	 * 判断对象是否是数字
	 * @param o 待判断的对象
	 * @return TRUE=是，否则不是
	 */
	public static boolean isNumber(Object o) {
		if(o==null) 
			return false;
		if(o instanceof Number) {
			return true;
		}
		if(o instanceof String) {
			String str = (String)o;
			if(str.length() == 0) 
				return false;
			if(str.trim().length() == 0) 
				return false;
			
			try {
				Double.parseDouble(str);
				return true;
			}catch(NumberFormatException e) {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * format(Java中使用%作为占位符,该方法会使用提供的参数替换占位符)<p>
	 * Java中字符串的占位符如下：<p>
	 * %s 字符串类型<p>
	 * %c 字符类型<p>
	 * %b 布尔类型<p>
	 * %d 整数类型（十进制）<p>
	 * %x 整数类型（十六进制）<p>
	 * %o 整数类型（八进制）<p>
	 * %f 浮点类型<p>
	 * %a 十六进制浮点类型<p>
	 * %e 指数类型<p>
	 * %g 通用浮点类型（f和e类型中较短的）<p>
	 * %h 散列码<p>
	 * %% 百分比类型<p>
	 * %n 换行符<p>
	 * %tx 日期与时间类型(x代表不同的日期与时间转换符,如%tY-%tm-%td %tH:%tM:%tS)<p>
	 * @param pattern 需要格式化的字符串。如: my name is %s. 则%s就是占位符
	 * @param args 替换占位符的参数
	 * @return 格式化后的字符串
	 */
	public static String format(String pattern, Object... args){
		return String.format(pattern, args);
	}
	
	/**
	 * 返回空的List
	 * @return List
	 */
	public static <E> List<E> emptyList(){
		return new ArrayList<E>();
	}
	
	/**
	 * 返回空的Set
	 * @return Set
	 */
	public static <E> Set<E> emptySet(){
		return new HashSet<E>();
	}
	
	/**
	 * 返回空的Map
	 * @return Map
	 */
	public static <K,V> Map<K,V> emptyMap(){
		return new HashMap<K,V>();
	}

}
