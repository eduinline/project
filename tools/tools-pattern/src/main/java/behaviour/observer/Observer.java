/**
 * tools-pattern
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年7月8日-下午2:56:40]
 * 
 */
package behaviour.observer;

/**
 * <p>观察者接口</p>
 * 
 * @version 1.0 2016年7月8日-下午2:56:40
 * @author hongze.he@eduinline.com
 */
public interface Observer {
	
	/**
	 * <p>观察者进行更新操作</p>
	 * @param subject
	 * @param params
	 */
	void update(Subject subject, Object params);
	
}
