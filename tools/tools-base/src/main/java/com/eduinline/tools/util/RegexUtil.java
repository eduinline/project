package com.eduinline.tools.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>com.helizfamily.tools.base.regex.RegexUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月18日-上午9:55:55
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 正则表达式处理工具类
 */
public class RegexUtil {
	
	/**
	 * getPattern(根据正则表达式获取Pattern)
	 * @param regex 正则表达式
	 * @return Pattern
	 */
	public static Pattern getPattern(String regex){
		return Pattern.compile(regex);
	}
	
	/**
	 * getMatcher(获取Matcher)
	 * @param regex 正则表达式
	 * @param handleStr 待处理的字符串
	 * @return Matcher
	 */
	public static Matcher getMatcher(String regex, String handleStr){
		Pattern p = getPattern(regex);
		Matcher matcher = p.matcher(handleStr);
		return matcher;
	}
	
	/**
	 * 判断字符串是否匹配正则
	 * @param regex 正则表达式
	 * @param handleStr 待处理的字符串
	 * @return true=匹配
	 */
	public static boolean isMatcher(String regex, String handleStr){
		Pattern p = getPattern(regex);
		Matcher matcher = p.matcher(handleStr);
		return matcher.matches();
	}
	
	/**
	 * getMatchResult(获取MatchResult)
	 * @param regex 正则表达式
	 * @param handleStr 待处理的字符串
	 * @return MatchResult
	 */
	public static MatchResult getMatchResult(String regex, String handleStr){
		Pattern p = getPattern(regex);
		Matcher matcher = p.matcher(handleStr);
		if(matcher.matches()){
			MatchResult matchResult = matcher.toMatchResult();
			return matchResult;
		}
		return null;
	}
	
	/**
	 * 从字符串中获取匹配正则的字符集合
	 * @param regex 正则表达式
	 * @param handleStr 字符源
	 * @return 匹配的结果集
	 */
	public static List<String> getResult(String regex, String handleStr){
		Pattern p = getPattern(regex);
		Matcher matcher = p.matcher(handleStr);
		List<String> result = new ArrayList<String>();
		while(matcher.find()){
			String group = matcher.group();
			if(null!=group && !"".equals(group))
				result.add(group);
		}
		return result;
	}
	
	/**
	 * 从字符串中获取匹配正则的字符集合
	 * @param regex 正则表达式组（正则表达式中含有多个小括号）
	 * @param handleStr 字符源
	 * @return 匹配的组结果(注意组的序号，组序号0始终代表整个表达式)
	 */
	public static List<String> getGroupResult(String regex, String handleStr){
		Pattern p = getPattern(regex);
		Matcher matcher = p.matcher(handleStr);
		List<String> result = new ArrayList<String>();
		while(matcher.find()){
			int group = matcher.groupCount();
			for(int i=1; i<group; i++){//组0始终代表整个表达式
				result.add(matcher.group(i));
			}
		}
		return result;
	}
	
}

