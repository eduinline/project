package com.eduinline.tools.base.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Base64;

/**
 * <p>com.helizfamily.tools.base.coder.UrlCoder.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月2日-下午5:31:09
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose Base64编码解码URL处理工具类
 */
public class Coder4Url {
	
	/**
	  * encode(Base64编码byte[])
	  * @param src 待编码的字节数组
	  * @return 编码后的字节数组
	  */
	public static byte[] encode(byte[] src){
		return Base64.getUrlEncoder().encode(src);
	}
	
	/**
	  * encodeToString(Base64编码byte[]转为字符)
	  * @param src 待编码的字节数组
	  * @return 编码后的字符串
	  */
	public static String encodeToString(byte[] src){
		return Base64.getUrlEncoder().encodeToString(src);
	}
	
	/**
	  * encode(Base64编码ByteBuffer)
	  * @param buffer 待编码的ByteBuffer
	  * @return 编码后的ByteBuffer
	  */
	public static ByteBuffer encode(ByteBuffer buffer){
		return Base64.getUrlEncoder().encode(buffer);
	}
	
	/**
	  * encode(Base64编码byte[]到目标byte[])
	  * @param src 待编码的byte[]
	  * @param dst 编码后的byte[]
	  * @return 编码后的字节长度
	  */
	public static int encode(byte[] src, byte[] dst){
		return Base64.getUrlEncoder().encode(src, dst);
	}
	
	/**
	  * wrap(使用Base64编码方案包装一个输出流)
	  * @param os 待编码的输出流
	  * @return 编码后的输出流
	  */
	public static OutputStream wrap(OutputStream os){
		return Base64.getUrlEncoder().wrap(os);
	}
	
	/**
	  * encode(Base64解码byte[])
	  * @param src 待解码的字节数组
	  * @return 解码后的字节数组
	  */
	public static byte[] decode(byte[] src){
		return Base64.getUrlDecoder().decode(src);
	}
	
	/**
	  * decode(Base64解码字符串为字节数组)
	  * @param src 待解码的字符串
	  * @return 解码后的字节数组
	  */
	public static byte[] decode(String src){
		return Base64.getUrlDecoder().decode(src);
	}
	
	/**
	  * encodeToString(Base64解码字符为字符串)
	  * @param src 待解码的字符串
	  * @return 解码后的字符串
	  */
	public static String decodeToString(String src){
		byte[] dst = Base64.getUrlDecoder().decode(src);
		return new String(dst);
	}
	
	/**
	  * encode(Base64解码ByteBuffer)
	  * @param buffer 待解码的ByteBuffer
	  * @return 解码后的ByteBuffer
	  */
	public static ByteBuffer decode(ByteBuffer buffer){
		return Base64.getUrlDecoder().decode(buffer);
	}
	
	/**
	  * encode(Base64解码byte[]到目标byte[])
	  * @param src 待解码的byte[]
	  * @param dst 解码后的byte[]
	  * @return 解码后的字节长度
	  */
	public static int decode(byte[] src, byte[] dst){
		return Base64.getUrlDecoder().decode(src, dst);
	}
	
	/**
	  * wrap(使用Base64编码方案解码一个输入流)
	  * @param os 待解码的输入流
	  * @return 解码后的输入流
	  */
	public static InputStream wrap(InputStream is){
		return Base64.getUrlDecoder().wrap(is);
	}
	
}

