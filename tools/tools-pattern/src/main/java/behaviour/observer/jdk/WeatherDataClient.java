/**
 * tools-pattern
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年7月8日-下午3:47:23]
 * 
 */
package behaviour.observer.jdk;

/**
 * <p>观察者模式测试入口</p>
 * 
 * @version 1.0 2016年7月8日-下午3:47:23
 * @author hongze.he@eduinline.com
 */
public class WeatherDataClient{
	
	public static void main(String[] args) {
		//1.创建观察中心
		WeatherData wd = new WeatherData();
		
		//2.创建观察者并注册到观察中心
		RoomDisplay rd = new RoomDisplay(wd);
		OutSideDisplay od = new OutSideDisplay(wd);
		
		//3.观察中心数据改变
		wd.setChangeDate(24.32, 13.33, 120);
		
		//4.观察者取消注册
		rd.disposy();
		od.disposy();
		
		//5.观察中心数据改变，这时观察者就不会再接收更新
		wd.setChangeDate(22.32, 15.33, 170);
		
	}

}
