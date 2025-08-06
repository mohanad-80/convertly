package com.konecta.internship.convertly.service;

import org.springframework.stereotype.Service;

import com.konecta.internship.convertly.enums.TimeUnit;

@Service
public class TimeService {
  public double convertTime(Double value, TimeUnit from, TimeUnit to) {
    double inSeconds = switch (from) {
      case Seconds -> value;
      case Minutes -> minutesToSeconds(value);
      case Hours -> hoursToSeconds(value);
      case Days -> daysToSeconds(value);
    };

    return switch (to) {
      case Seconds -> inSeconds;
      case Minutes -> secondsToMinutes(inSeconds);
      case Hours -> secondsToHours(inSeconds);
      case Days -> secondsToDays(inSeconds);
    };
  }

  private double minutesToSeconds(double min) {
    return min * 60;
  }

  private double hoursToSeconds(double hr) {
    return hr * 3600;
  }

  private double daysToSeconds(double day) {
    return day * 86400;
  }

  private double secondsToMinutes(double sec) {
    return sec / 60;
  }

  private double secondsToHours(double sec) {
    return sec / 3600;
  }

  private double secondsToDays(double sec) {
    return sec / 86400;
  }
}
