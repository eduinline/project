/**
 * tools-pattern
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年7月8日-下午3:51:53]
 * 
 */
package behaviour.observer.jdk;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * <p>室内展示温度数据，实现Observer接口</p>
 * 
 * @version 1.0 2016年7月8日-下午3:51:53
 * @author hongze.he@eduinline.com
 */
public class RoomDisplay implements Observer {
	
	/** 关联观察中心 */
	private Observable observable;
	
	/**
	 * 构造函数。加入到观察中心，方便后续观察接收数据。
	 * @param observable 可观察对象
	 */
	public RoomDisplay(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}

	@SuppressWarnings("unchecked")
	public void update(Observable o, Object arg) {
		Map<String, Object> data = (Map<String, Object>) arg;
		System.out.println("处理在室内展示数据："+data.toString());
	}
	
	/**
	 * <p>取消与观察中心的联系</p>
	 */
	public void disposy(){
		this.observable.deleteObserver(this);
	}

	public Observable getObservable() {
		return observable;
	}

	public void setObservable(Observable observable) {
		this.observable = observable;
	}
	
}
