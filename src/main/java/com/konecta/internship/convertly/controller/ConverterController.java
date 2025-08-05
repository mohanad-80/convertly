package com.konecta.internship.convertly.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konecta.internship.convertly.enums.Category;
import com.konecta.internship.convertly.enums.LengthUnit;
import com.konecta.internship.convertly.enums.TemperatureUnit;
import com.konecta.internship.convertly.enums.TimeUnit;
import com.konecta.internship.convertly.enums.WeightUnit;
import com.konecta.internship.convertly.exception.InvalidCategoryException;
import com.konecta.internship.convertly.model.ConversionRequest;
import com.konecta.internship.convertly.model.HealthResponse;

import jakarta.validation.Valid;

@RestController
public class ConverterController {
  @PostMapping("/convert")
  public void convert(@RequestBody @Valid ConversionRequest req){
    System.out.println(req.getCategory());
    System.out.println(req.getFromUnit());
    System.out.println(req.getToUnit());
    System.out.println(req.getValue());
  }

  @GetMapping("/categories")
  public Category[] getCategories() {
    return Category.values();
  }

  @GetMapping("/units")
  public String[] getCategoryUnits(@RequestParam String category) {
    category = category.toUpperCase();
    String[] result = new String[] {};

    if (Category.Temperature.name().toUpperCase().equals(category)) {
      result = Arrays.stream(TemperatureUnit.values()).map(TemperatureUnit::name).toArray(String[]::new);

    } else if (Category.Length.name().toUpperCase().equals(category)) {
      result = Arrays.stream(LengthUnit.values()).map(LengthUnit::name).toArray(String[]::new);

    } else if (Category.Weight.name().toUpperCase().equals(category)) {
      result = Arrays.stream(WeightUnit.values()).map(WeightUnit::name).toArray(String[]::new);

    } else if (Category.Time.name().toUpperCase().equals(category)) {
      result = Arrays.stream(TimeUnit.values()).map(TimeUnit::name).toArray(String[]::new);

    } else {
      throw new InvalidCategoryException("Invalid category name: " + category);
    }

    return result;
  }

  @GetMapping("/health")
  public HealthResponse checkHealth(){
    return new HealthResponse("Unit Converter API is up and running");
  }
}
