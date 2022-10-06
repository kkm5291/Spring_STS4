package com.tuyano.springboot;
import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface Phone {
	
	String message() default "please input a phone number.";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default{};
	
	boolean onlyNumber() default false; //defalut값을 false로 해놓겠다는 것같음
}
