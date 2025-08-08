package com.konecta.internship.convertly.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class FormulaTemplatesService {
  Map<String, String> formulaTemplates = new HashMap<>();

  public FormulaTemplatesService() {
    // Temperature Conversions
    // Celsius to others
    formulaTemplates.put("celsius_to_fahrenheit", "(${value}°C * 9/5) + 32 = ${result}°F");
    formulaTemplates.put("celsius_to_kelvin", "${value}°C + 273.15 = ${result}K");

    // Fahrenheit to others
    formulaTemplates.put("fahrenheit_to_celsius", "(${value}°F - 32) * 5/9 = ${result}°C");
    formulaTemplates.put("fahrenheit_to_kelvin", "(${value}°F - 32) * 5/9 + 273.15 = ${result}K");

    // Kelvin to others
    formulaTemplates.put("kelvin_to_celsius", "${value}K - 273.15 = ${result}°C");
    formulaTemplates.put("kelvin_to_fahrenheit", "(${value}K - 273.15) * 9/5 + 32 = ${result}°F");

    // Length Conversions
    // Meter to others
    formulaTemplates.put("meter_to_kilometer", "${value}m / 1000 = ${result}km");
    formulaTemplates.put("meter_to_mile", "${value}m / 1609.34 = ${result}mi");
    formulaTemplates.put("meter_to_inch", "${value}m * 39.3701 = ${result}in");
    formulaTemplates.put("meter_to_foot", "${value}m * 3.28084 = ${result}ft");

    // Kilometer to others
    formulaTemplates.put("kilometer_to_meter", "${value}km * 1000 = ${result}m");
    formulaTemplates.put("kilometer_to_mile", "${value}km * 0.621371 = ${result}mi");
    formulaTemplates.put("kilometer_to_inch", "${value}km * 39370.1 = ${result}in");
    formulaTemplates.put("kilometer_to_foot", "${value}km * 3280.84 = ${result}ft");

    // Mile to others
    formulaTemplates.put("mile_to_meter", "${value}mi * 1609.34 = ${result}m");
    formulaTemplates.put("mile_to_kilometer", "${value}mi * 1.60934 = ${result}km");
    formulaTemplates.put("mile_to_inch", "${value}mi * 63360 = ${result}in");
    formulaTemplates.put("mile_to_foot", "${value}mi * 5280 = ${result}ft");

    // Inch to others
    formulaTemplates.put("inch_to_meter", "${value}in * 0.0254 = ${result}m");
    formulaTemplates.put("inch_to_kilometer", "${value}in * 0.0000254 = ${result}km");
    formulaTemplates.put("inch_to_mile", "${value}in / 63360 = ${result}mi");
    formulaTemplates.put("inch_to_foot", "${value}in / 12 = ${result}ft");

    // Foot to others
    formulaTemplates.put("foot_to_meter", "${value}ft * 0.3048 = ${result}m");
    formulaTemplates.put("foot_to_kilometer", "${value}ft * 0.0003048 = ${result}km");
    formulaTemplates.put("foot_to_mile", "${value}ft / 5280 = ${result}mi");
    formulaTemplates.put("foot_to_inch", "${value}ft * 12 = ${result}in");

    // Weight Conversions
    // Gram to others
    formulaTemplates.put("gram_to_kilogram", "${value}g / 1000 = ${result}kg");
    formulaTemplates.put("gram_to_pound", "${value}g / 453.59237 = ${result}lb");
    formulaTemplates.put("gram_to_ounce", "${value}g / 28.349523125 = ${result}oz");

    // Kilogram to others
    formulaTemplates.put("kilogram_to_gram", "${value}kg * 1000 = ${result}g");
    formulaTemplates.put("kilogram_to_pound", "${value}kg * 2.2046226218 = ${result}lb");
    formulaTemplates.put("kilogram_to_ounce", "${value}kg * 35.27396195 = ${result}oz");

    // Pound to others
    formulaTemplates.put("pound_to_gram", "${value}lb * 453.59237 = ${result}g");
    formulaTemplates.put("pound_to_kilogram", "${value}lb / 2.2046226218 = ${result}kg");
    formulaTemplates.put("pound_to_ounce", "${value}lb * 16 = ${result}oz");

    // Ounce to others
    formulaTemplates.put("ounce_to_gram", "${value}oz * 28.349523125 = ${result}g");
    formulaTemplates.put("ounce_to_kilogram", "${value}oz / 35.27396195 = ${result}kg");
    formulaTemplates.put("ounce_to_pound", "${value}oz / 16 = ${result}lb");

    // Time Conversions
    // Seconds to others
    formulaTemplates.put("seconds_to_minutes", "${value}s / 60 = ${result}min");
    formulaTemplates.put("seconds_to_hours", "${value}s / 3600 = ${result}hr");
    formulaTemplates.put("seconds_to_days", "${value}s / 86400 = ${result}d");

    // Minutes to others
    formulaTemplates.put("minutes_to_seconds", "${value}min * 60 = ${result}s");
    formulaTemplates.put("minutes_to_hours", "${value}min / 60 = ${result}hr");
    formulaTemplates.put("minutes_to_days", "${value}min / 1440 = ${result}d");

    // Hours to others
    formulaTemplates.put("hours_to_seconds", "${value}hr * 3600 = ${result}s");
    formulaTemplates.put("hours_to_minutes", "${value}hr * 60 = ${result}min");
    formulaTemplates.put("hours_to_days", "${value}hr / 24 = ${result}d");

    // Days to others
    formulaTemplates.put("days_to_seconds", "${value}d * 86400 = ${result}s");
    formulaTemplates.put("days_to_minutes", "${value}d * 1440 = ${result}min");
    formulaTemplates.put("days_to_hours", "${value}d * 24 = ${result}hr");
  }

  public String getFormula(String fromUnit, String toUnit, Double value, Double result) {
    String conversionKey = fromUnit.toLowerCase() + "_to_" + toUnit.toLowerCase();
    String formulaTemplate = this.formulaTemplates.get(conversionKey);
    return formulaTemplate.replace("${value}", String.valueOf(value))
        .replace("${result}", String.valueOf(result));
  }
}
