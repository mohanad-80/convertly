package com.konecta.internship.convertly.service;

import org.springframework.stereotype.Service;

import com.konecta.internship.convertly.enums.WeightUnit;

@Service
public class WeightService {
  public double convertWeight(Double value, WeightUnit from, WeightUnit to) {
    double inGrams = switch (from) {
      case Gram -> value;
      case Kilogram -> kilogramToGram(value);
      case Pound -> poundToGram(value);
      case Ounce -> ounceToGram(value);
    };

    return switch (to) {
      case Gram -> inGrams;
      case Kilogram -> gramToKilogram(inGrams);
      case Pound -> gramToPound(inGrams);
      case Ounce -> gramToOunce(inGrams);
    };
  }

  private double kilogramToGram(double kg) {
    return kg * 1000;
  }

  private double poundToGram(double lb) {
    return lb * 453.592;
  }

  private double ounceToGram(double oz) {
    return oz * 28.3495;
  }

  private double gramToKilogram(double g) {
    return g / 1000;
  }

  private double gramToPound(double g) {
    return g / 453.592;
  }

  private double gramToOunce(double g) {
    return g / 28.3495;
  }
}
