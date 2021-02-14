package com.test.weather.coolesthour.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.weather.coolesthour.model.Location;
import com.test.weather.coolesthour.model.TemperatureAtTime;


public interface TemperatureForecastService {
    List<TemperatureAtTime> getTemperatureForeCastForGeoPosition(Location location);
}
