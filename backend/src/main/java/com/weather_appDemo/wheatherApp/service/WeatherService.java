package com.weather_appDemo.wheatherApp.service;

import com.weather_appDemo.wheatherApp.model.CityCoordinate;
import com.weather_appDemo.wheatherApp.model.CityWeather;
import com.weather_appDemo.wheatherApp.model.WeatherRequest;
import com.weather_appDemo.wheatherApp.providerService.GeocodingProviderService;
import com.weather_appDemo.wheatherApp.providerService.GeocodingTransformerservice;
import com.weather_appDemo.wheatherApp.providerService.OpenWeatherTransformer;
import com.weather_appDemo.wheatherApp.providerService.WeatherProviderService;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private GeocodingProviderService geocodingProviderService;
    private WeatherProviderService weatherProviderService;
    private OpenWeatherTransformer openweatherTransformer;

    public WeatherService(WeatherProviderService weatherProviderService, GeocodingProviderService geocodingProviderService, OpenWeatherTransformer openweatherTransformer, GeocodingTransformerservice geocodingTransformerservice) {
        this.weatherProviderService = weatherProviderService;
        this.geocodingProviderService = geocodingProviderService;
        this.openweatherTransformer = openweatherTransformer;
        this.geocodingTransformerservice = geocodingTransformerservice;
    }

    private GeocodingTransformerservice geocodingTransformerservice;
    public  CityWeather getWeather(WeatherRequest weatheRequest) throws Exception {
//        get the Coordinate
        CityCoordinate cityCoordinate = geocodingTransformerservice.trans(geocodingProviderService.getCoordinate(weatheRequest));
//        get the Weather for the Coordinate
        CityWeather cityWeather = openweatherTransformer.trans(weatherProviderService.getWeather(cityCoordinate));
        return cityWeather;
    }
}
