/**
 * tools-pattern
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年7月14日-下午3:50:17]
 * 
 */
package create.factorymethod;

/**
 * <p>工厂方法模式：适用创建单类型的对象</p>
 * <ul>
 * 	<li>特点1：定义一个创建对象的抽象类，由子类实现创建具体对象的处理。工厂方法让类把实例化推迟到子类</li>
 * 	<li>特点2：orderPizza方法可以设置一些公共的属性和行为</li>
 * </ul>
 * @version 1.0 2016年7月14日-下午3:50:17
 * @author hongze.he@eduinline.com
 */
public abstract class FactoryMethodAbs {
	
	/**
	 * <p>根据不同的类型订购披萨</p>
	 * @param type 披萨类型
	 * @return Pizza
	 */
	public Pizza orderPizza(String type){
		Pizza pizza = createPizza(type);
		//此处可以设置pizza的一些功能属性
		return pizza;
	}

	/**
	 * <p>具体如何制作披萨，由其子类实现</p>
	 * @param type 披萨类型
	 * @return Pizza
	 */
	protected abstract Pizza createPizza(String type);

}
