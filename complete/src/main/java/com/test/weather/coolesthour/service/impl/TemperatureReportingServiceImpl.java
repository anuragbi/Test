package com.test.weather.coolesthour.service.impl;

import com.test.weather.coolesthour.model.TemperatureAtTime;
import com.test.weather.coolesthour.service.TemperatureReportingService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * This service reports the temperature in a given format.
 * <p>
 * This service also detects the coolest temperature of the day and highlights it during reporting
 */
@Service
public class TemperatureReportingServiceImpl implements TemperatureReportingService {
    @Value("${report.date.format}")
    private String reportDateFormat;

    @Override
    public void printTemperatures(List<TemperatureAtTime> temperatures) {
        TemperatureAtTime minimumTemperature = getMinimumTemp(temperatures);
        for (TemperatureAtTime temperature : temperatures) {
            if (temperature.compareTo(minimumTemperature) == 0) {
                reportDateFormat = "dd MMM yyyy - hh:mm a";
                System.out.println("--The-Coolest-Hour--> The temperature at hour " + temperature.getTime().format(DateTimeFormatter.ofPattern(reportDateFormat)) + " is " + temperature.getValue() + "°C<---");
            } else {
                System.out.println("The temperature at hour " + temperature.getTime().format(DateTimeFormatter.ofPattern("dd MMM yyyy - hh:mm a")) + " is " + temperature.getValue() + "°C");
            }
        }
    }

    
    @Override
    public double getMinimumTemperature(List<TemperatureAtTime> temperatures) {
        TemperatureAtTime minimumTemperature = getMinimumTemp(temperatures);
        double min=0;
        for (TemperatureAtTime temperature : temperatures) {
            if (temperature.compareTo(minimumTemperature) == 0) {
                reportDateFormat = "dd MMM yyyy - hh:mm a";
                 min= temperature.getValue();
                return min;
              //  System.out.println("--The-Coolest-Hour--> The temperature at hour " + temperature.getTime().format(DateTimeFormatter.ofPattern(reportDateFormat)) + " is " + temperature.getValue() + "°C<---");
            } else {
               // System.out.println("The temperature at hour " + temperature.getTime().format(DateTimeFormatter.ofPattern("dd MMM yyyy - hh:mm a")) + " is " + temperature.getValue() + "°C");
            }
        }
		return min;
    }
    
     TemperatureAtTime getMinimumTemp(List<TemperatureAtTime> temperatures) {
        TemperatureAtTime minValue = temperatures.get(0);
        for (int i = 1; i < temperatures.size(); i++) {
            if (temperatures.get(i).compareTo(minValue) < 1) {
                minValue = temperatures.get(i);
            }
        }
        return minValue;
    }
}
