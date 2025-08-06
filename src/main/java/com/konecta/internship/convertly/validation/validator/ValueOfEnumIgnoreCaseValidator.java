package com.konecta.internship.convertly.validation.validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.konecta.internship.convertly.validation.annotation.ValueOfEnumIgnoreCase;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValueOfEnumIgnoreCaseValidator implements ConstraintValidator<ValueOfEnumIgnoreCase, String> {
  private List<String> acceptedValues;

  @Override
  public void initialize(ValueOfEnumIgnoreCase annotation) {
    acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
        .map(enumVal -> enumVal.name().toLowerCase())
        .collect(Collectors.toList());
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null)
      return true; // Let @NotNull handle nulls if needed

    return acceptedValues.contains(value.toLowerCase());
  }

}
