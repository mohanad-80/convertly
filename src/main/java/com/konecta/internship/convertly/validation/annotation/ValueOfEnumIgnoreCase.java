package com.konecta.internship.convertly.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.konecta.internship.convertly.validation.validator.ValueOfEnumIgnoreCaseValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValueOfEnumIgnoreCaseValidator.class)
@Documented
public @interface ValueOfEnumIgnoreCase {
  Class<? extends Enum<?>> enumClass();

  String message() default "invalid value";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
