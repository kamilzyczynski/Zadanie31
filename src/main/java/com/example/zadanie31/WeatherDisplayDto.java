package com.example.zadanie31;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherDisplayDto {
    private String cityName;
    private double temp;
    private int humidity;
    private int pressure;
    private int visibility;
    private double windSpeed;
}
