package com.weather_appDemo.wheatherApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityCoordinate {
    private String latitude;
    private String longitude;
}
