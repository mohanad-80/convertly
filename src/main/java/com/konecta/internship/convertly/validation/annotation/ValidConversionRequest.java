package com.konecta.internship.convertly.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.konecta.internship.convertly.validation.validator.ConversionRequestValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConversionRequestValidator.class)
@Documented
public @interface ValidConversionRequest {
  String message() default "Invalid conversion request";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
