/**
 * tools-pattern
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年7月8日-下午3:47:23]
 * 
 */
package behaviour.observer.jdk;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * <p>使用JDK自带的观察者模式实现天气数据的观察。缺点：Observable是实现类，有违针对接口编程原则</p>
 * 
 * @version 1.0 2016年7月8日-下午3:47:23
 * @author hongze.he@eduinline.com
 */
public class WeatherData extends Observable {
	
	/** 温度 */
	private double temperatrue;
	
	/** 湿度 */
	private double humidity;
	
	/** 压力 */
	private double pressure;
	
	/**
	 * <p>更新检测数据，数据更新后会通知观察者</p>
	 * @param temperatrue 温度
	 * @param humidity 湿度
	 * @param pressure 压力
	 */
	public void setChangeDate(double temperatrue, double humidity, double pressure){
		this.temperatrue = temperatrue;
		this.humidity = humidity;
		this.pressure = pressure;
		notifyChange();
	}
	
	/**
	 * <p>数据改变时通知观察者</p>
	 */
	public void notifyChange(){
		setChanged();
		notifyObservers(getChangeData());//参数为发送给观察者的数据
	}
	
	/**
	 * <p>返回更改的数据给客户端:这里使用JSon格式以String传递是否更好？</p>
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getChangeData(){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("temperatrue", this.getTemperatrue());
		data.put("humidity", this.getHumidity());
		data.put("pressure", this.getPressure());
		return data;
	}

	public double getTemperatrue() {
		return temperatrue;
	}

	public double getHumidity() {
		return humidity;
	}

	public double getPressure() {
		return pressure;
	}

}
