package com.konecta.internship.convertly.service;

import org.springframework.stereotype.Service;

import com.konecta.internship.convertly.enums.LengthUnit;

@Service
public class LengthService {
  public double convertLength(Double value, LengthUnit fromUnit, LengthUnit toUnit) {
    double inMeters = switch (fromUnit) {
      case Foot -> footToMeter(value);
      case Inch -> inchToMeter(value);
      case Kilometer -> kilometerToMeter(value);
      case Mile -> mileToMeter(value);
      case Meter -> value;
    };

    return switch (toUnit) {
      case Foot -> meterToFoot(inMeters);
      case Inch -> meterToInch(inMeters);
      case Kilometer -> meterToKilometer(inMeters);
      case Mile -> meterToMile(inMeters);
      case Meter -> inMeters;
    };
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
