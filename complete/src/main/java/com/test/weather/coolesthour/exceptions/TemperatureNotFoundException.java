package com.test.weather.coolesthour.exceptions;

public class TemperatureNotFoundException extends RuntimeException {


    public TemperatureNotFoundException(String message) {
        super(message);
    }

}
