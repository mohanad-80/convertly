package com.konecta.internship.convertly.service;

import org.springframework.stereotype.Service;

import com.konecta.internship.convertly.enums.LengthUnit;

@Service
public class LengthService {
  public double convertLength(Integer value, LengthUnit fromUnit, LengthUnit toUnit) {
    double inMeters = 0.0;
    switch (fromUnit) {
      case Foot:
        inMeters = footToMeter(value);
        break;
      case Inch:
        inMeters = inchToMeter(value);
        break;
      case Kilometer:
        inMeters = kilometerToMeter(value);
        break;
      case Mile:
        inMeters = mileToMeter(value);
        break;
      case Meter:
        inMeters = value;
        break;
    }

    double result = 0.0;
    switch (toUnit) {
      case Foot:
        result = meterToFoot(inMeters);
        break;
      case Inch:
        result = meterToInch(inMeters);
        break;
      case Kilometer:
        result = meterToKilometer(inMeters);
        break;
      case Mile:
        result = meterToMile(inMeters);
        break;
      case Meter:
        result = inMeters;
        break;
    }

    return result;
  }

  private double kilometerToMeter(double km) {
    return km * 1000;
  }

  private double mileToMeter(double mile) {
    return mile * 1609.34;
  }

  private double inchToMeter(double inch) {
    return inch * 0.0254;
  }

  private double footToMeter(double foot) {
    return foot * 0.3048;
  }

  private double meterToKilometer(double meter) {
    return meter / 1000;
  }

  private double meterToMile(double meter) {
    return meter / 1609.34;
  }

  private double meterToInch(double meter) {
    return meter / 0.0254;
  }

  private double meterToFoot(double meter) {
    return meter / 0.3048;
  }
}
