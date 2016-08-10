/**
 * tools-validate
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年8月10日-上午10:25:46]
 * 
 */
package com.eduinline.tools.validate.test;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <p></p>
 * <ul>
 * 	<li></li>
 * </ul>
 * @version 1.0 2016年8月10日-上午10:25:46
 * @author hongze.he@eduinline.com
 */
public class Car {
	@NotNull()
	private String manufacturer;
	
	@NotNull
	@Size(min = 2, max = 14)
	private String licensePlate;
	
	@Min(2)
	private int seatCount;
	public Car(String manufacturer, String licencePlate, int seatCount) {
		this.manufacturer = manufacturer;
		this.licensePlate = licencePlate;
		this.seatCount = seatCount;
	}
}
