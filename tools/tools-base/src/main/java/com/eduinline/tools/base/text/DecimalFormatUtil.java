package com.eduinline.tools.base.text;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * <p>com.helizfamily.tools.base.text.DecimalFormatUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月7日-上午8:52:10
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 数字格式化的工具类，可设置小数的位数、整数的位数，多少位分一组等。更多操作方法请参考JDK自带的DecimalFormat <br> 
 *  <strong>符号 	位置 	本地化？ 	含义</strong><br>
 * 	0 	数字 	是 	阿拉伯数字<br>
 * 	# 	数字字 	是 	阿拉伯数字，如果不存在则显示为空<br>
 * 	. 	数字 	是 	小数分隔符或货币小数分隔符<br>
 * 	- 	数字 	是 	减号<br>
 *	, 	数字 	是 	分组分隔符<br>
 *	E 	数字 	是 	分隔科学计数法中的尾数和指数。在前缀或后缀中无需加引号。<br>
 *	; 	子模式边界 	是 	分隔正数和负数子模式<br>
 *	% 	前缀或后缀 	是 	乘以 100 并显示为百分数<br>
 *	/u2030 	前缀或后缀 	是 	乘以 1000 并显示为千分数<br>
 *	¤(/u00A4) 	前缀或后缀 	否 	货币记号，由货币符号替换。如果两个同时出现，则用国际货币符号替换。如果出现在某个模式中，则使用货币小数分隔符，而不使用小数分隔符。<br>
 *	' 	前缀或后缀 	否 	用于在前缀或或后缀中为特殊字符加引号，例如 "'#'#" 将 123 格式化为 "#123"。要创建单引号本身，请连续使用两个单引号："# o''clock"。<br>
 */
public class DecimalFormatUtil {
	
	/** 全局数字格式化对象，用于format数字 */
	static DecimalFormat format = new DecimalFormat();
	
	/** 全局数字格式化对象，用于parse数字  */
	static DecimalFormat parse = new DecimalFormat();
	
	/**
	 * 使用给定的模式格式化数字，返回格式化后的字符串
	 * @param pattern 模式
	 * @param number 需要格式化的数字
	 * @return 格式化后的数字
	 */
	public static String format(String pattern, Object number){
		format.applyPattern(pattern);
		return format.format(number);
	}
	
	/**
	 * 将一个字符串转为数字
	 * @param source 需要转换的字符串
	 * @return 数字
	 * @throws ParseException
	 */
	public static Number parse(String source) throws ParseException{
		return parse.parse(source);
	}
	/**
	 * 远离零方向舍入的舍入模式。<strong>始终对非零舍弃部分前面的数字加 1</strong>。注意，此舍入模式始终不会减少计算值的绝对值
	 */
	public static final RoundingMode UP = RoundingMode.UP;
	
	/**
	 * 向零方向舍入的舍入模式。<strong>从不对舍弃部分前面的数字加 1（即截尾）</strong>。注意，此舍入模式始终不会增加计算值的绝对值。 
	 */
	public static final RoundingMode DOWN = RoundingMode.DOWN;
	
	/**
	 * 向正无限大方向舍入的舍入模式。如果结果为正，则舍入行为类似于 RoundingMode.UP；
	 * 如果结果为负，则舍入行为类似于 RoundingMode.DOWN。注意，此舍入模式始终不会减少计算值。
	 */
	public static final RoundingMode CEILING = RoundingMode.CEILING;
	
	/**
	 * 向负无限大方向舍入的舍入模式。如果结果为正，则舍入行为类似于 RoundingMode.DOWN；
	 * 如果结果为负，则舍入行为类似于RoundingMode.UP。注意，此舍入模式始终不会增加计算值。 
	 */
	public static final RoundingMode FLOOR = RoundingMode.FLOOR;
	
	/**
	 * 向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向上舍入。
	 * 如果被舍弃部分 >= 0.5，则舍入行为同 RoundingMode.UP；
	 * 否则舍入行为同RoundingMode.DOWN。注意，此舍入模式就是通常学校里讲的<strong>四舍五入</strong>。
	 */
	public static final RoundingMode HALF_UP = RoundingMode.HALF_UP;
	
	/**
	 * 向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向下舍入。
	 * 如果被舍弃部分 > 0.5，则舍入行为同 RoundingMode.UP；否则舍入行为同RoundingMode.DOWN。
	 */
	public static final RoundingMode HALF_DOWN = RoundingMode.HALF_DOWN;
	
	/**
	 * DecimalFormat默认使用的取舍策略
	 * 向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。
	 * 如果舍弃部分左边的数字为奇数，则舍入行为同 RoundingMode.HALF_UP；
	 * 如果为偶数，则舍入行为同RoundingMode.HALF_DOWN。
	 * 注意，在重复进行一系列计算时，此舍入模式可以在统计上将累加错误减到最小。此舍入模式也称为“银行家舍入法”，
	 * 主要在美国使用。此舍入模式类似于 Java 中对float和double算法使用的舍入策略
	 */
	public static final RoundingMode HALF_EVEN = RoundingMode.HALF_EVEN;
	
}

