package com.weather_appDemo.wheatherApp.providerService;

import com.weather_appDemo.wheatherApp.model.CityCoordinate;
import com.weather_appDemo.wheatherApp.model.GeocodingCoordinatesEntity;
import org.springframework.stereotype.Service;

@Service
public class GeocodingTransformerservice {
    public CityCoordinate trans(GeocodingCoordinatesEntity coordinate) {
        return new CityCoordinate(coordinate.getLat(), coordinate.getLon());
    }
}
