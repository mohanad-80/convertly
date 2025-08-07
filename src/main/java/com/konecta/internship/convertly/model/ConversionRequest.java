package com.konecta.internship.convertly.model;

import com.konecta.internship.convertly.enums.Category;
import com.konecta.internship.convertly.validation.annotation.ValidConversionRequest;
import com.konecta.internship.convertly.validation.annotation.ValueOfEnumIgnoreCase;

import jakarta.validation.constraints.NotNull;

@ValidConversionRequest
public class ConversionRequest {
  @NotNull
  @ValueOfEnumIgnoreCase(enumClass = Category.class, message = "invalid category")
  private String category;

  @NotNull
  private String fromUnit;

  @NotNull
  private String toUnit;

  @NotNull
  private Double value;

  public ConversionRequest() {
  }

  public ConversionRequest(@NotNull String category, @NotNull String fromUnit, @NotNull String toUnit,
      @NotNull Double value) {
    this.category = category;
    this.fromUnit = fromUnit;
    this.toUnit = toUnit;
    this.value = value;
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

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }
}
