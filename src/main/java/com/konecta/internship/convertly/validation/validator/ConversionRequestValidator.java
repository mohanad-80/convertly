package com.konecta.internship.convertly.validation.validator;

import com.konecta.internship.convertly.enums.Category;
import com.konecta.internship.convertly.enums.LengthUnit;
import com.konecta.internship.convertly.enums.TemperatureUnit;
import com.konecta.internship.convertly.enums.TimeUnit;
import com.konecta.internship.convertly.enums.WeightUnit;
import com.konecta.internship.convertly.model.ConversionRequest;
import com.konecta.internship.convertly.validation.annotation.ValidConversionRequest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ConversionRequestValidator implements ConstraintValidator<ValidConversionRequest, ConversionRequest> {

  @Override
  public boolean isValid(ConversionRequest request, ConstraintValidatorContext context) {
    if (request == null)
      return true; // Let @NotNull handle this

    String category = request.getCategory();
    String from = request.getFromUnit();
    String to = request.getToUnit();
    int value = request.getValue();

    if (category == null)
      return true; // Let @NotNull handle null category

    Category cat;
    try {
      cat = Category.valueOf(category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase());
    } catch (IllegalArgumentException e) {
      return true; // Let the enum validator handle this
    }

    boolean valid = true;

    switch (cat) {
      case Length:
        valid &= isInEnum(from, LengthUnit.class, context, "fromUnit");
        valid &= isInEnum(to, LengthUnit.class, context, "toUnit");
        valid &= validateValue(value, cat, context);
        break;
      case Weight:
        valid &= isInEnum(from, WeightUnit.class, context, "fromUnit");
        valid &= isInEnum(to, WeightUnit.class, context, "toUnit");
        valid &= validateValue(value, cat, context);
        break;
      case Temperature:
        valid &= isInEnum(from, TemperatureUnit.class, context, "fromUnit");
        valid &= isInEnum(to, TemperatureUnit.class, context, "toUnit");
        valid &= validateValue(value, cat, context);
        break;
      case Time:
        valid &= isInEnum(from, TimeUnit.class, context, "fromUnit");
        valid &= isInEnum(to, TimeUnit.class, context, "toUnit");
        valid &= validateValue(value, cat, context);
        break;
      default:
        valid = false;
    }

    return valid;
  }

  private boolean isInEnum(String value, Class<? extends Enum<?>> enumClass,
      ConstraintValidatorContext context, String fieldName) {
    if (value == null)
      return false;

    for (Enum<?> enumVal : enumClass.getEnumConstants()) {
      if (enumVal.name().equalsIgnoreCase(value))
        return true;
    }

    context.disableDefaultConstraintViolation();
    context.buildConstraintViolationWithTemplate("Invalid unit: " + value)
        .addPropertyNode(fieldName)
        .addConstraintViolation();
    return false;
  }

  private boolean validateValue(int value, Category category, ConstraintValidatorContext context) {
    boolean allowNegative = category == Category.Temperature; // Only allow for temperature

    if (!allowNegative && value < 0) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate("Negative values are not allowed for " + category)
          .addPropertyNode("value")
          .addConstraintViolation();
      return false;
    }

    return true;
  }
}
