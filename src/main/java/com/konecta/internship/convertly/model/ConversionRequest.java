package com.konecta.internship.convertly.model;

import com.konecta.internship.convertly.enums.Category;
import com.konecta.internship.convertly.validation.annotation.ValueOfEnumIgnoreCase;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ConversionRequest {
  @NotNull
  @ValueOfEnumIgnoreCase(enumClass = Category.class, message = "invalid category")
  private String category;
  @NotBlank
  private String fromUnit;
  @NotBlank
  private String toUnit;
  @Positive
  private int value;

  public ConversionRequest() {
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getFromUnit() {
    return fromUnit;
  }

  public void setFromUnit(String fromUnit) {
    this.fromUnit = fromUnit;
  }

  public String getToUnit() {
    return toUnit;
  }

  public void setToUnit(String toUnit) {
    this.toUnit = toUnit;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
