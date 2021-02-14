package com.test.weather.coolesthour.service;

import com.test.weather.coolesthour.model.Location;

public interface ZipCodeDetailsService {
    Location getLocationFromZipCode(String zipcode);
}
