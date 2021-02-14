package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.weather.coolesthour.integrations.service.impl.HTTPClientService;
import com.test.weather.coolesthour.service.TemperatureForecastService;
import com.test.weather.coolesthour.service.TemperatureReportingService;
import com.test.weather.coolesthour.service.ZipCodeDetailsService;
import com.test.weather.coolesthour.service.impl.TemperatureForecastServiceImpl;
import com.test.weather.coolesthour.service.impl.TemperatureReportingServiceImpl;
import com.test.weather.coolesthour.service.impl.USZipCodeDetailsServiceImpl;


@Configuration
public class ApplicationBeans {
    @Value("${temperature.service.location}")
    private String darkSkyServiceLocation;

    
    @Bean
    public TemperatureForecastService getTemp()
    {
    	return new TemperatureForecastServiceImpl(new HTTPClientService());
    }
    
    @Bean
    public TemperatureReportingService getTemperatureReportingService()
    {
    	return new TemperatureReportingServiceImpl();
    }
    
    @Bean
    public ZipCodeDetailsService getZipCodeDetailsService()
    {
    	return new USZipCodeDetailsServiceImpl(new HTTPClientService());
    }
}

