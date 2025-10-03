package com.weather_appDemo.wheatherApp.providerService;

import com.weather_appDemo.wheatherApp.model.CityWeather;
import com.weather_appDemo.wheatherApp.model.OpenWeatherResponseEntity;
import com.weather_appDemo.wheatherApp.model.WeatherEntity;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherTransformer {
    public CityWeather trans(OpenWeatherResponseEntity weather) {
        return CityWeather.builder().weather(weather.getWeather()[0].getMain()).
        details(weather.getWeather()[0].getDescription()).build();
    }
}
