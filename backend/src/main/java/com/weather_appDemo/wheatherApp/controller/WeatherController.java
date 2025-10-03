package com.weather_appDemo.wheatherApp.controller;

import com.weather_appDemo.wheatherApp.model.CityWeather;
import com.weather_appDemo.wheatherApp.model.WeatheResponse;
import com.weather_appDemo.wheatherApp.model.WeatherRequest;
import com.weather_appDemo.wheatherApp.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {
    private final WeatherService weatherService;
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @GetMapping("weather/{city}")
    public @ResponseBody CityWeather weather(@PathVariable String city) throws Exception {
        WeatherRequest weatheRequest = WeatherRequest
                .builder().city(city).build();
        return weatherService.getWeather(weatheRequest);
    }
}
