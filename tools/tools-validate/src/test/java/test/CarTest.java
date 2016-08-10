/**
 * tools-validate
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年8月10日-上午10:28:31]
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.eduinline.tools.validate.test.Car;

/**
 * <p></p>
 * <ul>
 * 	<li></li>
 * </ul>
 * @version 1.0 2016年8月10日-上午10:28:31
 * @author hongze.he@eduinline.com
 */
public class CarTest {
	
	private static Validator validator;
	
	@BeforeClass
	public static void setUpValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void manufacturerIsNull() {
		Car car = new Car( null, "a", 1 );
		Set<ConstraintViolation<Car>> constraintViolations =
				validator.validate( car );
		Iterator<ConstraintViolation<Car>> iterator = 
				constraintViolations.iterator();
		while(iterator.hasNext()){
			ConstraintViolation<Car> cv = iterator.next();
			System.out.println(cv.getPropertyPath());
			System.out.println(cv.getInvalidValue());
			System.out.println(cv.getMessage());
			System.out.println(cv.getMessageTemplate());
		}
	}
	
	@Test
	public void licensePlateTooShort() {
		Car car = new Car( "Morris", "D", 4 );
		Set<ConstraintViolation<Car>> constraintViolations =
				validator.validate( car );
		assertEquals( 1, constraintViolations.size() );
		assertEquals(
				"size must be between 2 and 14",
				constraintViolations.iterator().next().getMessage()
				);
	}
	@Test
	public void seatCountTooLow() {
		Car car = new Car( "Morris", "DD-AB-123", 1 );
		Set<ConstraintViolation<Car>> constraintViolations =
				validator.validate( car );
		assertEquals( 1, constraintViolations.size() );
		assertEquals(
				"must be greater than or equal to 2",
				constraintViolations.iterator().next().getMessage()
				);
	}
	@Test
	public void carIsValid() {
		Car car = new Car( "Morris", "DD-AB-123", 2 );
		Set<ConstraintViolation<Car>> constraintViolations =
				validator.validate( car );
		assertEquals( 0, constraintViolations.size() );
	}
}
