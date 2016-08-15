package com.eduinline.tools.base.util;

import java.security.SecureRandom;
import java.util.UUID;

/**
* <p>com.helizfamily.tools.base.id.IdUtil.java</p>
*
* @author hezliz hezliz@qq.com
* @version 1.0 2016年2月1日-下午2:33:14
* @modifyed hezliz hezliz@qq.com
* @purpose ID生成器
*/
public class IdUtil {
	
	private static final String SPLIT_CHAR = "-";
	
	private static final String BLANK_CHAR = "";
	
	private static final char[] BASE62 = 
			"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	
	/** SecureRandom对象 */
	private static SecureRandom random = new SecureRandom();

	/**
	  * uuid(封装JDK自带的UUID, 通过Random数字生成, 中间有-分割)
	  * @return
	  */
	public static String uuid1() {
		return UUID.randomUUID().toString();
	}

	/**
	  * uuid2(封装JDK自带的UUID, 通过Random数字生成, 中间无-分割)
	  * @return
	  */
	public static String uuid2() {
		return UUID.randomUUID().toString().replaceAll(SPLIT_CHAR, BLANK_CHAR);
	}

	/**
	  * randomLong(使用SecureRandom生成随机Long)
	  * @return
	  */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	/**
	  * randomBase62(基于Base62编码的SecureRandom随机生成bytes)
	  * @param length 随机ID的长度
	  * @return
	  */
	public static String randomBase62(int length) {
		byte[] randomBytes = new byte[length];
		random.nextBytes(randomBytes);
		return encodeBase62(randomBytes);
	}
	
	/**
	  * encodeBase62(使用62位种子生成随机字符)
	  * @param input 字节流
	  * @return
	  */
	public static String encodeBase62(byte[] input) {
		char[] chars = new char[input.length];
		for (int i = 0; i < input.length; i++) {
			chars[i] = BASE62[(input[i] & 0xFF) % BASE62.length];
		}
		return new String(chars);
	}
	
}
