package com.weather_appDemo.wheatherApp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherEntity {
    private int id;
    private String main;
    private String description;
    private String icon;


}
