package com.weather_appDemo.wheatherApp.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
@Data

public class WeatherRequest {
    @Getter
    private String city;
}
