package com.test.weather.coolesthour.service;

import java.util.List;

import com.test.weather.coolesthour.model.TemperatureAtTime;

public interface TemperatureReportingService {
    void printTemperatures(List<TemperatureAtTime> temperatures);
    public double getMinimumTemperature(List<TemperatureAtTime> temperatures);
    
}
