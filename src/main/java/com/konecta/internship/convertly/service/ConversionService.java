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
    double result = 0.0;

    switch (category) {
      case Length:
        result = lengthService.convertLength(req.getValue(),
            LengthUnit.valueOf(req.getFromUnit()),
            LengthUnit.valueOf(req.getToUnit()));
        break;
      case Temperature:
        result = temperatureService.convertTemperature(req.getValue(),
            TemperatureUnit.valueOf(req.getFromUnit()),
            TemperatureUnit.valueOf(req.getToUnit()));
        break;
      case Time:
        result = timeService.convertTime(req.getValue(),
            TimeUnit.valueOf(req.getFromUnit()),
            TimeUnit.valueOf(req.getToUnit()));
        break;
      case Weight:
        result = weightService.convertWeight(req.getValue(),
            WeightUnit.valueOf(req.getFromUnit()),
            WeightUnit.valueOf(req.getToUnit()));
        break;
    }

    return result;
  }
}
