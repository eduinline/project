package com.eduinline.tools.base.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * <p>com.helizfamily.tools.base.security.EncryptUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月4日-下午2:52:26
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose 加密解密工具类。包括MD5、DES、RSA等算法
 */
public class EncryptUtil {

	private static final int KEY_SIZE = 1024;
	/** MD5单向加密算法。特点：不可解密 */
	private static final String  MD5_ALGORITHM= "md5";
	/** DES对称加密算法。特点：加密放和解密放使用相同的密钥 */
	private static final String  DES_ALGORITHM= "des";
	/** RSA非对称加密算法。特点：密钥有公钥和私钥 */
	private static final String  RSA_ALGORITHM= "rsa";
	/** 签名算法 */
	private static final String  SIGNATURE_ALGORITHM= "MD5withRSA";

	/** 消息摘要对象 */
	private static MessageDigest md5;
	/** 强安全随机数对象 */
	private static SecureRandom random;
	/** RSA密钥对象 */
	private static KeyPair keyPair;

	/** 初始化 */
	static {
		try {
			md5 = MessageDigest.getInstance(MD5_ALGORITHM);
			KeyPairGenerator keyPairGenerator = 
					KeyPairGenerator.getInstance(RSA_ALGORITHM);
			keyPairGenerator.initialize(KEY_SIZE);
			keyPair = keyPairGenerator.generateKeyPair();
			random = new SecureRandom();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("算法不存在："+e.getMessage());
		}
	}

	/**
	 * encryptMD5(使用MD5加密算法加密明文)
	 * @param plainText 待加密的明文
	 * @return 经过MD5加密的密文
	 */
	public static String encryptMD5(String plainText) {
		byte[] cipherData = md5.digest(plainText.getBytes());
		StringBuffer sb = new StringBuffer();
		for (byte b : cipherData) {
			String toHexStr = Integer.toHexString(b & 0xff);
			sb.append(toHexStr.length() == 1 ? "0" + toHexStr : toHexStr);
		}
		return sb.toString();
	}

	/**
	 * equalsMD5(判断明文和密文是否相等)
	 * @param plainText 待校验的明文
	 * @param ciphertext 加密后的密文
	 * @return true=相等；false=不相等
	 */
	public static boolean equalsMD5(String plainText, String ciphertext){
		String text = encryptMD5(plainText);
		if(text.equals(ciphertext))
			return true;
		return false;
	}
	
	/**
	 * createSecretKey(根据字符key创建DES密钥SecretKey)
	 * @param key 提供的秘钥
	 * @return SecretKey密钥
	 * @throws Exception
	 */
	private static SecretKey createSecretKey(String key) throws Exception {
		try {
			DESKeySpec keySpec = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES_ALGORITHM);
			SecretKey secretKey = keyFactory.generateSecret(keySpec);
			return secretKey;
		}catch (Exception e) {
			System.out.println("生成密钥失败："+e.getMessage());
			throw new Exception(e);
		}
	}
	
	/**
	 * encryptDES(使用DES对称加密算法进行加密)
	 * @param plainData 带加密的字符串
	 * @param key 密钥
	 * @return 加密后的字符串
	 * @throws Exception 
	 */
	public static String encryptDES(String plainText, String key) throws Exception {
		byte[] plainData = plainText.getBytes();
		byte[] cipherData =  encryptDES(plainData, key);
		return Base64.getEncoder().encodeToString(cipherData);
	}
	
	/**
	 * encryptDES(使用DES对称加密算法进行加密)
	 * @param plainData 带加密的字节数组
	 * @param key 密钥
	 * @return 加密后的字节数组
	 * @throws Exception 
	 */
	public static byte[] encryptDES(byte[] plainData, String key) throws Exception {
		return processCipher(plainData, createSecretKey(key),
				Cipher.ENCRYPT_MODE, DES_ALGORITHM);
	}
	
	/**
	 * decryptDES(使用DES对称加密算法进行解密)
	 * @param cipherData 密文字符串
	 * @param key 密钥
	 * @return 解密后的明文
	 * @throws Exception 
	 */
	public static String decryptDES(String cipherText, String key) throws Exception {
		byte[] cipherData = Base64.getDecoder().decode(cipherText);
		byte[] plainData = decryptDES(cipherData, key);
		return new String(plainData);
	}
	
	/**
	 * decryptDES(使用DES对称加密算法进行解密)
	 * @param cipherData 密文字节数组
	 * @param key 密钥
	 * @return 解密后的字节数组
	 * @throws Exception 
	 */
	public static byte[] decryptDES(byte[] cipherData, String key) throws Exception {
		return processCipher(cipherData, createSecretKey(key),
				Cipher.DECRYPT_MODE, DES_ALGORITHM);
	}
	
	/**
	 * createPrivateKey(创建私钥，用于RSA非对称加密)
	 * @return 私钥
	 */
	public static PrivateKey createPrivateKey() {
		return keyPair.getPrivate();
	}

	/**
	 * createPublicKey(创建公钥，用于RSA非对称加密)
	 * @return 公钥
	 */
	public static PublicKey createPublicKey() {
		return keyPair.getPublic();
	}
	
	/**
	 * writeKeyToFile(把钥匙序列化到文件)
	 * @param file 序列化密钥的文件对象
	 * @param key 钥匙
	 * @throws IOException
	 */
	public static void writeKeyToFile(File file, Key key) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(key);
		if(null!=oos)
			oos.close();
		if(null!=fos)
			fos.close();
	}
	
	/**
	 * readKeyFromFile(从文件读取Key)
	 * @param file 反序列化密钥的文件对象
	 * @return Key
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Key readKeyFromFile(File file) 
			throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream bis = new ObjectInputStream(fis);
		Object object = bis.readObject();
		if(null!=bis)
			bis.close();
		if(null!=fis)
			fis.close();
		return (Key) object;
	}
	
	/**
	 * encryptRSA(使用RSA算法加密)
	 * @param plainText 明文字符
	 * @param key 密钥
	 * @return 加密后的密文字符
	 * @throws Exception
	 */
	public static String encryptRSA(String plainText, Key key) throws Exception {
		byte[] plainData = plainText.getBytes();
		byte[] cipherData =  encryptRSA(plainData, key);
		return Base64.getEncoder().encodeToString(cipherData);
	}

	/**
	 * encryptRSA(使用RSA算法加密)
	 * @param plainData 明文字节数组
	 * @param key 密钥
	 * @return 加密后的字节数组
	 * @throws Exception
	 */
	public static byte[] encryptRSA(byte[] plainData, Key key) throws Exception {
		return processCipher(plainData, key, Cipher.ENCRYPT_MODE, RSA_ALGORITHM);
	}
	
	/**
	 * decryptRSA(使用RSA算法解密)
	 * @param cipherData 密文字符
	 * @param key 密钥
	 * @return 明文字符
	 * @throws Exception
	 */
	public static String decryptRSA(String cipherText, Key key) throws Exception {
		byte[] cipherData = Base64.getDecoder().decode(cipherText);
		byte[] plainData = decryptRSA(cipherData, key);
		return new String(plainData);
	}

	/**
	 * decryptRSA(使用RSA算法解密)
	 * @param cipherData 密文字节数组
	 * @param key 密钥
	 * @return 解密后的字节数组
	 * @throws Exception
	 */
	public static byte[] decryptRSA(byte[] cipherData, Key key) throws Exception {
		return processCipher(cipherData, key, Cipher.DECRYPT_MODE, RSA_ALGORITHM);
	}
	
	/**
	 * createSignature(使用私钥对加密数据创建数字签名)
	 * @param cipherData 加密的数据
	 * @param privateKey 私钥
	 * @return 数字签名
	 * @throws Exception
	 */
	public static byte[] createSignature(byte[] cipherData, 
			PrivateKey privateKey) throws Exception {
		Signature signature  = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(privateKey);
		signature.update(cipherData);
		return signature.sign();
	}

	/**
	 * verifySignature(使用公钥对数字签名进行验证)
	 * @param cipherData 加密的数据
	 * @param signData 数字签名
	 * @param publicKey 公钥
	 * @return true=验证通过;false=验证失败
	 * @throws Exception
	 */
	public static boolean verifySignature(byte[] cipherData, byte[] signData, 
			PublicKey publicKey) throws Exception {
		Signature signature  = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(publicKey);
		signature.update(cipherData);
		return signature.verify(signData);
	}
	
	/**
	 * processCipher(加密/解密处理流程)
	 * @param processData 待处理的字节数组
	 * @param key 提供的秘钥
	 * @param opsMode 工作模式
	 * @param algorithm 使用的算法
	 * @return 加密后的字节数组
	 * @throws Exception
	 */
	private static byte[] processCipher(byte[] processData, Key key, 
			int opsMode, String algorithm) throws Exception{
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(opsMode, key, random);
		return cipher.doFinal(processData);
	}
}

