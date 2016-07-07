/**
 * tools-pattern
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年7月7日-下午4:23:09]
 * 
 */
package behaviour.strategy;

/**
 * <p>策略模式。本例使用支付功能简单说明策略模式的原理</p>
 * <ul>
 * 	<li>
 * 		策略模式定义了一系列的算法，并将每一个算法封装起来，而且使它们还可以相互替换。
 * 		策略模式让算法独立于使用它的客户而独立变化。
 * 	</li>
 *  <li>
 *  	在支付功能里：对于客户端来说，进行支付行为是单一的，就是支付。但对于后台处理支付功能的服务来说，
 *  	支付的处理方法却是根据不同的银行而有所不同，也就是说，支付的业务是变化的，但是相对于客户是透明。
 *  </li>
 * </ul>
 * @version 1.0 2016年7月7日-下午4:23:09
 * @author hongze.he@eduinline.com
 */
public class Strategy {
	
	/** 工商银行 */
	public static final String ICBC = "ICBC";
	
	/** 支付接口 */
	private Pay pay;
	
	/**
	 * <p>策略模式测试入口</p>
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}
	
}
