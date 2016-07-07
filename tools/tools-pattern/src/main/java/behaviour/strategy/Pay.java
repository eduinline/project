/**
 * tools-pattern
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年7月7日-下午4:39:49]
 * 
 */
package behaviour.strategy;

/**
 * <p>支付接口</p>
 * 
 * @version 1.0 2016年7月7日-下午4:39:49
 * @author hongze.he@eduinline.com
 */
public interface Pay {
	
	/**
	 * <p>支付方法，根据提交的支付参数进行支付处理</p>
	 * @param payParams 提交的支付参数（实际应用中支付参数会很多）
	 * @return true：支付成功；false：失败（实际应用中返回参数也不止一个）
	 */
	boolean doPay(String payParams);
	
}
