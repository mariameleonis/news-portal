package com.epam.newsportal.validator;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDate {
	String message() default "Date must be in YYYY-MM-DD format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
