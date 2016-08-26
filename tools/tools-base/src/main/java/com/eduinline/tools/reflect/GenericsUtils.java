package com.eduinline.tools.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p>泛型工具类</p>
 * <ul>
 * 	<li></li>
 * </ul>
 * @version 1.0 2016年8月26日-下午4:46:47
 * @author hongze.he@eduinline.com
 */
public class GenericsUtils {

	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	public static Class getSuperClassGenricType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}
}
