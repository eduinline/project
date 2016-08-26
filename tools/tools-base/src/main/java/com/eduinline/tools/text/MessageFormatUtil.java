package com.eduinline.tools.text;

import java.text.MessageFormat;
import java.text.ParseException;

/**
 * <p>com.helizfamily.tools.base.text.MessageFormatUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年3月7日-上午8:53:31
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 处理Message格式化的工具类，更多操作请参考JKD自带的MessageFormat类
 * <br>{1,number,#.##}这种格式的使用，请参考MessageFormat类API
 */
public class MessageFormatUtil {
	
	/**
	 * 根据指定模式格式化字符串
	 * @param pattern 模式。如："{0} pay {1,number,#.##} on the {2}"
	 * @param arguments 设置给模式的参数数据
	 * @return 格式化后的字符串
	 */
	public static String format(String pattern, Object... arguments){
		return MessageFormat.format(pattern, arguments);
	}
	
	/**
	 * 根据模式把字符串中的参数提取出来
	 * @param pattern 模式
	 * @param source 需要处理的字符
	 * @return 参数数组
	 * @throws ParseException
	 */
	public static Object[] parse(String pattern, String source) throws ParseException{
		MessageFormat mf = new MessageFormat(pattern);
		return mf.parse(source);
	}
	
}

