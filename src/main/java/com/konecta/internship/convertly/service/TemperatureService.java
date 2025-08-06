package com.konecta.internship.convertly.service;

import org.springframework.stereotype.Service;

import com.konecta.internship.convertly.enums.TemperatureUnit;

@Service
public class TemperatureService {
  public double convertTemperature(Double value, TemperatureUnit from, TemperatureUnit to) {
    double inCelsius = switch (from) {
      case Celsius -> value;
      case Fahrenheit -> (value - 32) * 5 / 9;
      case Kelvin -> value - 273.15;
    };

    return switch (to) {
      case Celsius -> inCelsius;
      case Fahrenheit -> inCelsius * 9 / 5 + 32;
      case Kelvin -> inCelsius + 273.15;
    };
  }
}
