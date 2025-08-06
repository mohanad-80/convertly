package com.konecta.internship.convertly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konecta.internship.convertly.enums.Category;
import com.konecta.internship.convertly.enums.LengthUnit;
import com.konecta.internship.convertly.model.ConversionRequest;

@Service
public class ConversionService {
  @Autowired
  private LengthService lengthService;

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

        break;
      case Time:

        break;
      case Weight:

        break;

      default:
        break;
    }

    return result;
  }
}
