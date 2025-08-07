package com.konecta.internship.convertly.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.konecta.internship.convertly.model.ConversionResponse;
import com.konecta.internship.convertly.model.HealthResponse;
import com.konecta.internship.convertly.service.ConversionService;

import jakarta.validation.Valid;

@RestController
public class ConverterController {
  @Autowired
  private ConversionService conversionService;

  @PostMapping("/convert")
  public ConversionResponse convert(@RequestBody @Valid ConversionRequest req) {
    double result = conversionService.convert(req);
    return new ConversionResponse(result, "success");
  }

  @GetMapping("/categories")
  public Category[] getCategories() {
    return Category.values();
  }

  @GetMapping("/units")
  public String[] getCategoryUnits(@RequestParam String category) {
    category = category.toUpperCase();
    String[] result = new String[] {};

    if (Category.Temperature.name().equalsIgnoreCase(category)) {
      result = Arrays.stream(TemperatureUnit.values()).map(TemperatureUnit::name).toArray(String[]::new);

    } else if (Category.Length.name().equalsIgnoreCase(category)) {
      result = Arrays.stream(LengthUnit.values()).map(LengthUnit::name).toArray(String[]::new);

    } else if (Category.Weight.name().equalsIgnoreCase(category)) {
      result = Arrays.stream(WeightUnit.values()).map(WeightUnit::name).toArray(String[]::new);

    } else if (Category.Time.name().equalsIgnoreCase(category)) {
      result = Arrays.stream(TimeUnit.values()).map(TimeUnit::name).toArray(String[]::new);

    } else {
      throw new InvalidCategoryException("Invalid category name: " + category);
    }

    return result;
  }

  @GetMapping("/sample-payload")
  public ConversionRequest sample() {
    return new ConversionRequest("Temperature", "Celsius", "Fahrenheit", 25.0);
  }

  @GetMapping("/health")
  public HealthResponse checkHealth() {
    return new HealthResponse("Unit Converter API is up and running");
  }
}
