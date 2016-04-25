package com.eduinline.tools.base.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <p>com.helizfamily.tools.base.io.SerializeUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月19日-下午4:28:02
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose JDK序列化、反序列化工具类
 */
public class IOSerializeUtil {

	/**
	 * serialize(序列化)
	 * @param object 需要序列化的对象
	 * @return 序列化后的二进制字节数组
	 * @throws IOException
	 */
	public static byte[] serialize(Serializable object) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		try{
			oos.writeObject(object);
			return baos.toByteArray();
		}finally{
			if(null!=baos)
				baos.close();
			if(null!=oos)
				oos.close();
		}
	}

	/**
	 * unserialize(反序列化)
	 * @param bytes 字节数组
	 * @return 对象
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object unserialize(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		try{
			return ois.readObject();
		}finally{
			if(null!=bais)
				bais.close();
			if(null!=ois)
				ois.close();
		}
	}
	
}

