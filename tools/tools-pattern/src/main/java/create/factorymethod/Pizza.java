/**
 * tools-pattern
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年7月14日-下午4:00:13]
 * 
 */
package create.factorymethod;

import java.util.ArrayList;

/**
 * <p>抽象披萨类，由子类继续实现个性化</p>
 * <ul>
 * 	<li></li>
 * </ul>
 * @version 1.0 2016年7月14日-下午4:00:13
 * @author hongze.he@eduinline.com
 */
public abstract class Pizza {
	/** 名称 */
	protected String name;
	/** 面团类型 */
	protected String dough;
	/** 酱料类型 */
	protected String sauce;
	/** 制作步骤 */
	protected ArrayList<String> toppings = new ArrayList<String>();
	
	/**
	 * <p>预处理：提供一些默认的做法和功能的功能</p>
	 */
	void prepare(){
		System.out.println("Preparing "+name);
		System.out.println("");
		System.out.println("");
		for (String top : toppings) {
			System.out.println(top);
		}
	}
}
