/**
 * tools-pattern
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年7月8日-下午2:54:09]
 * 
 */
package behaviour.observer;

/**
 * <p>主题接口,定义了主题和观察者一对多的关系</p>
 * 
 * @version 1.0 2016年7月8日-下午2:54:09
 * @author hongze.he@eduinline.com
 */
public interface Subject {
	
	/**
	 * <p>注册观察者</p>
	 * @param observer 观察者对象
	 */
	public void addObserver(Observer observer);
	
	/**
	 * <p>删除观察者</p>
	 * @param observer 观察者对象
	 */
	public void deleteObserver(Observer observer);
	
	/**
	 * <p>删除全部观察者</p>
	 */
	public void deleteObserver();
	
	/**
	 * <p>通知观察者</p>
	 * @param params 传递的参数
	 */
	public void notifyObservers(Object params);
	
	/**
	 * <p>获取观察者数量</p>
	 * @return 当前观察者数量
	 */
	public int countObservers();
	
}
