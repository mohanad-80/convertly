package com.konecta.internship.convertly.model;

import java.time.LocalDateTime;

public class ConversionRecord {
  private String category;
  private String fromUnit;
  private String toUnit;
  private double value;
  private double result;
  private LocalDateTime timestamp;

  public ConversionRecord(String category, String fromUnit, String toUnit, double value, double result) {
    this.category = category;
    this.fromUnit = fromUnit;
    this.toUnit = toUnit;
    this.value = value;
    this.result = result;
    this.timestamp = LocalDateTime.now();
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

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public double getResult() {
    return result;
  }

  public void setResult(double result) {
    this.result = result;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}
