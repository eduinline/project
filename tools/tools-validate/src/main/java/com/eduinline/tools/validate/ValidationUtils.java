/**
 * tools-validate
 *
 * Copyright(C)2016-2016 eduinline.com
 *
 * Created By eduinline Team on [2016年8月10日-上午9:21:32]
 * 
 */
package com.eduinline.tools.validate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

/**
 * <p>Hibernate Validate后台对象校验工具类</p>
 * 
 * @version 1.0 2016年8月10日-上午9:21:32
 * @author hongze.he@eduinline.com
 */
public class ValidationUtils {

	private static Validator validator =  
			Validation.buildDefaultValidatorFactory().getValidator();

	public static <T> ValidationResult validateEntity(T obj){
		ValidationResult result = new ValidationResult();
		Set<ConstraintViolation<T>> set = validator.validate(obj,Default.class);
		if(!set.isEmpty()){
			result.setHasErrors(true);
			Map<String,String> errorMsg = new HashMap<String,String>();
			for(ConstraintViolation<T> cv : set){
				errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
			}
			result.setErrorMsg(errorMsg);
		}
		return result;
	}

	public static <T> ValidationResult validateProperty(T obj, String propertyName){
		ValidationResult result = new ValidationResult();
		Set<ConstraintViolation<T>> set = validator.validateProperty(obj,propertyName,Default.class);
		if(!set.isEmpty()){
			result.setHasErrors(true);
			Map<String,String> errorMsg = new HashMap<String,String>();
			for(ConstraintViolation<T> cv : set){
				errorMsg.put(propertyName, cv.getMessage());
			}
			result.setErrorMsg(errorMsg);
		}
		return result;
	}
}
