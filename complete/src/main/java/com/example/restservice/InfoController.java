package com.example.restservice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.weather.coolesthour.model.Location;
import com.test.weather.coolesthour.model.TemperatureAtTime;
import com.test.weather.coolesthour.service.TemperatureForecastService;
import com.test.weather.coolesthour.service.TemperatureReportingService;
import com.test.weather.coolesthour.service.ZipCodeDetailsService;

@RestController
public class InfoController {

//	@Autowired(required = true)
//	public void setTemperatureForecastServiceimpl(TemperatureForecastService temperatureForecastServiceimpl) {
//	    this.temperatureForecastServiceimpl = temperatureForecastServiceimpl;
//	}
//	
//	@Autowired(required = true)
//	public void setTemperatureReportingService(TemperatureReportingService temperatureReportingService) {
//	    this.temperatureReportingService = temperatureReportingService;
//	}
//	
//	@Autowired(required = true)
//	public void setZipCodeDetailsService(ZipCodeDetailsService zipCodeDetailsService) {
//	    this.zipCodeDetailsService = zipCodeDetailsService;
//	}
	/////////
	@Autowired
	TemperatureForecastService temperatureForecastServiceimpl;
	@Autowired
	TemperatureReportingService temperatureReportingService;
	@Autowired
	ZipCodeDetailsService zipCodeDetailsService;

	@Value("${default.zipcode}")
	private String defaultZipcode;

	@GetMapping("/weatherinfo")
	public List<TemperatureAtTime> greeting(@RequestParam(value = "zipcode", defaultValue = "10001") String zipcode) {
		List<TemperatureAtTime> temperatures = null;
		LocalDate tomorrow = LocalDate.from(LocalDate.now()).plusDays(1);
		try {
			Location location = zipCodeDetailsService.getLocationFromZipCode(zipcode);
			System.out
					.println("Checking the weather for " + tomorrow.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
							+ " at " + zipcode + "(" + location.getName() + ")");
			temperatures = temperatureForecastServiceimpl.getTemperatureForeCastForGeoPosition(location);
			
			temperatureReportingService.printTemperatures(temperatures);
			double minTemp=temperatureReportingService.getMinimumTemperature(temperatures);
			System.out.println("this is min temp::::::::::::::::"+minTemp);
			temperatures.add(new TemperatureAtTime(minTemp, null, minTemp));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		return temperatures;
	}
}
