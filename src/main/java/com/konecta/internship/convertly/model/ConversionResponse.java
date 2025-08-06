package com.konecta.internship.convertly.model;

public class ConversionResponse {
  private double result;
  private String status;

  public ConversionResponse(double result, String status) {
    this.result = result;
    this.status = status;
  }

  public double getResult() {
    return result;
  }

  public void setResult(double result) {
    this.result = result;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
