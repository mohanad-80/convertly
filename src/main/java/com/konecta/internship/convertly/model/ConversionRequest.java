package com.konecta.internship.convertly.model;

public class ConversionRequest {
  private String category;
  private String fromUnit;
  private String toUnit;
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
