package com.konecta.internship.convertly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konecta.internship.convertly.enums.Category;
import com.konecta.internship.convertly.enums.LengthUnit;
import com.konecta.internship.convertly.enums.TemperatureUnit;
import com.konecta.internship.convertly.enums.TimeUnit;
import com.konecta.internship.convertly.enums.WeightUnit;
import com.konecta.internship.convertly.model.ConversionRequest;

@Service
public class ConversionService {
  @Autowired
  private LengthService lengthService;
  @Autowired
  private TimeService timeService;
  @Autowired
  private WeightService weightService;
  @Autowired
  private TemperatureService temperatureService;

  public double convert(ConversionRequest req) {
    Category category = Category
        .valueOf(req.getCategory().substring(0, 1).toUpperCase() + req.getCategory().substring(1).toLowerCase());
    String fromUnit = req.getFromUnit().substring(0, 1).toUpperCase() + req.getFromUnit().substring(1).toLowerCase();
    String toUnit = req.getToUnit().substring(0, 1).toUpperCase() + req.getToUnit().substring(1).toLowerCase();
    double result = 0.0;

    switch (category) {
      case Length:
        result = lengthService.convertLength(req.getValue(),
            LengthUnit.valueOf(fromUnit),
            LengthUnit.valueOf(toUnit));
        break;
      case Temperature:
        result = temperatureService.convertTemperature(req.getValue(),
            TemperatureUnit.valueOf(fromUnit),
            TemperatureUnit.valueOf(toUnit));
        break;
      case Time:
        result = timeService.convertTime(req.getValue(),
            TimeUnit.valueOf(fromUnit),
            TimeUnit.valueOf(toUnit));
        break;
      case Weight:
        result = weightService.convertWeight(req.getValue(),
            WeightUnit.valueOf(fromUnit),
            WeightUnit.valueOf(toUnit));
        break;
    }

    return result;
  }
}
