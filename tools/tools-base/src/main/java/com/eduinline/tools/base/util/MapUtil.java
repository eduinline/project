package com.eduinline.tools.base.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>com.helizfamily.tools.base.util.MapUtil.java</p>
 *
 * @author helizfamily helizfamily@qq.com
 * @version 1.0 2016年2月29日-下午4:59:38
 * @modifyed helizfamily helizfamily@qq.com
 * @purpose Map处理工具类
 */
public class MapUtil {
	
	/**
	 * 判断Map是否为空
	 * @param map Map对象
	 * @return true=空
	 */
	public static <K, V> boolean isEmpty(Map<K, V> map){
		if(null==map || map.isEmpty())
			return true;
		return false;
	}
	
	/**
	 * 基于哈希表的 Map接口的实现。此实现提供所有可选的映射操作，并允许使用null值和null键，非同步。
	 * <br>此类不保证映射的顺序，特别是它不保证该顺序恒久不变。
	 * <br>实现同步：Map m = Collections.synchronizedMap(new HashMap(...));
	 * @return HashMap
	 */
	public static <K, V> HashMap<K, V> hashMap(){
		return new HashMap<K, V>();
	}
	
	/**
	 * 基于哈希表的 Map接口的实现。此实现提供所有可选的映射操作，不允许使用null值和null键，同步。
	 * <br>此类不保证映射的顺序，特别是它不保证该顺序恒久不变。
	 * @return Hashtable
	 */
	public static <K, V> Hashtable<K, V> hashTable(){
		return new Hashtable<K, V>();
	}
	
	/**
	 * 支持获取的完全并发和更新的所期望可调整并发的哈希表。此类遵守与 Hashtable 相同的功能规范，同步。
	 * <br>尽管所有操作都是线程安全的，但获取操作不必锁定，并且不支持以某种防止所有访问的方式锁定整个表
	 * @return ConcurrentHashMap
	 */
	public static <K, V> ConcurrentHashMap<K, V> concurrentHashMap(){
		return new ConcurrentHashMap<K, V>();
	}
	
	/**
	 * 基于红黑树（Red-Black tree）的 NavigableMap实现，非同步
	 * <br>实现同步：SortedMap m = Collections.synchronizedSortedMap(new TreeMap(...));
	 * @return TreeMap
	 */
	public static <K, V> TreeMap<K, V> treeMap(){
		return new TreeMap<K, V>();
	}
	
	/**
	 * 此类利用哈希表实现 Map接口，比较键（和值）时使用引用相等性代替对象相等性。当且仅当 (k1==k2) 时，才认为两个键 k1 和 k2 相等
	 * <br>实现同步：Map m = Collections.synchronizedMap(new HashMap(...)); 
	 * @return IdentityHashMap
	 */
	public static <K,V> IdentityHashMap<K,V> identityHashMap(){
		return new IdentityHashMap<K,V>();
	}
	
	/**
	 * <p>把Map转换为Bean</p>
	 * @param map Map对象
	 * @param obj Bean对象
	 * @throws Exception
	 */
	public static void map2Bean(Map<String, Object> map, Object obj) throws Exception{
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] propertyDescriptors = 
				beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor property : propertyDescriptors){
            String key = property.getName();
            if (map.containsKey(key)) {
                Object value = map.get(key);
                Method setter = property.getWriteMethod();
                setter.invoke(obj, value);
            }
        }
    }
	
	private static final String NAME_CLASS = "class";
  
	/**
	 * <p>把Bean转换为Map</p>
	 * @param obj Bean对象
	 * @return Map<String, Object>
	 * @throws Exception
	 */
    public static Map<String, Object> bean2Map(Object obj) throws Exception{
    	Map<String, Object> map = new HashMap<String, Object>();
        if(obj==null)
            return map;
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
        return map;
    }
    
}

