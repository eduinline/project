package com.eduinline.tools.reflect;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>反射工具类：处理Java中常用的反射处理功能。</p>
 * <ul>
 * 	<li>1.处理泛型的反射处理</li>
 *  <li>2.对类对象设置属性值、获取属性值以及执行方法</li>
 * </ul>
 * @version 1.0 2016年8月26日-上午10:21:11
 * @author hongze.he@eduinline.com
 */
public class ReflectUtil {
	
	/** 类描述 */
	private static final String NAME_CLASS = "class";
	
	/** 日志对象 */
	private static Logger logger = LoggerFactory.getLogger(ReflectUtil.class);
	
	/**
	 * <p>把Bean转换为Map</p>
	 * @param obj Bean对象
	 * @return Map<String, Object>
	 * @throws Exception
	 */
    public static Map<String, Object> bean2Map(Object obj){
    	Map<String, Object> map = new HashMap<String, Object>();
        if(obj==null)
            return map;
        try{
        	BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor property : propertyDescriptors){
                String key = property.getName();
                if(!key.equals(NAME_CLASS)){
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    map.put(key, value);
                }
            }
        }catch(Exception e){
        	logger.error("Bean转Map异常", e);
        }
        return map;
    }
    
    /**
	 * <p>把Map设置到Bean属性中</p>
	 * @param obj Bean对象
	 * @param fieldMap Map对象属性
	 * @return true=设置成功，否则失败
	 */
    public static boolean map2Bean(Object obj, Map<String, Object> fieldMap){
        return setValues(obj, fieldMap);
    }
	
	/**
	 * <p>获取对象属性值</p>
	 * @param obj 需要反射的对象
	 * @param field 属性名称
	 * @return 属性值
	 */
	public static Object getValue(Object obj, String field){
		Object value = null;
		if(null==obj)
			return value;
		try{
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
	        PropertyDescriptor[] propertyDescriptors = 
	        		beanInfo.getPropertyDescriptors();
	        for(PropertyDescriptor property : propertyDescriptors){
	            String key = property.getName();
	            if(!key.equals(NAME_CLASS) && key.equals(field)){
	                Method getter = property.getReadMethod();
	                value = getter.invoke(obj);
	            }
	        }
	        return value;
		}catch(Exception e){
			logger.error("反射获取属性值异常", e);
			return value;
		}
	}
	
	/**
	 * <p>获取对象多个属性值</p>
	 * @param obj 需要反射的对象
	 * @param fields 属性名称数组
	 * @return 属性值Map<field, fieldVal>
	 */
	public static Map<String, Object> getValues(Object obj, String... fields){
		Map<String, Object> result = new HashMap<String, Object>();
		if(null==obj)
			return result;
		List<String> fieldList = Arrays.asList(fields);
		try{
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
	        PropertyDescriptor[] propertyDescriptors = 
	        		beanInfo.getPropertyDescriptors();
	        for(PropertyDescriptor property : propertyDescriptors){
	            String key = property.getName();
	            if(!key.equals(NAME_CLASS) && fieldList.contains(key)){
	                Method getter = property.getReadMethod();
	                Object value = getter.invoke(obj);
	                result.put(key, value);
	            }
	        }
	        return result;
		}catch(Exception e){
			logger.error("反射获取属性值异常", e);
			return result;
		}
	}
	
	/**
	 * <p>设置对象属性值</p>
	 * @param obj 需要反射的对象
	 * @param field 属性名称
	 * @param fieldVal 属性值
	 * @return true=设置成功；false失败
	 */
	public static boolean setValue(Object obj, String field, Object fieldVal){
		if(null==obj)
			return false;
		try{
			PropertyDescriptor propDesc = new PropertyDescriptor(field, obj.getClass());
			Method setter = propDesc.getWriteMethod();
            setter.invoke(obj, fieldVal);
	        return false;
		}catch(Exception e){
			logger.error("反射设置属性值异常", e);
			return false;
		}
	}
	
	/**
	 * <p>设置对象属性值</p>
	 * @param obj 需要反射的对象
	 * @param fieldMap 属性键值对
	 * @return true=设置成功；false失败
	 */
	public static boolean setValues(Object obj, Map<String, Object> fieldMap){
		if(null==obj)
			return false;
		try{
			Iterator<String> iterator = fieldMap.keySet().iterator();
			while(iterator.hasNext()){
				String field = iterator.next();
				setValue(obj, field, fieldMap.get(field));
			}
	        return true;
		}catch(Exception e){
			logger.error("反射设置属性值异常", e);
			return false;
		}
	}
	
	/**
	 * <p>执行对象方法</p>
	 * @param obj 需要反射的对象
	 * @param methodName 方法名称
	 * @param args 方法参数
	 * @return 执行方法后的返回值
	 */
	public static Object executeMethod(Object obj, String methodName, Object... args){
		if(null==obj)
			return null;
		try{
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
	        for(MethodDescriptor methodDescriptor : methodDescriptors){
	            String name = methodDescriptor.getName();
	            if(name.equals(methodName)){
	                Method method = methodDescriptor.getMethod();
	                Class<?>[] paramsTypes = method.getParameterTypes();
	                if(args.length==paramsTypes.length){
	                	boolean targetMethod = true;
	                	for(int i=0; i<args.length; i++){
	                		if(!args[i].getClass().equals(paramsTypes[i]))
	                			targetMethod = false;
	                	}
	                	if(targetMethod){
	                		return method.invoke(obj, args);
	                	}else{
	                		continue;
	                	}
	                }
	            }
	        }
	        return null;
		}catch(Exception e){
			logger.error("反射执行对象方法异常", e);
			return null;
		}
	}
	
}
