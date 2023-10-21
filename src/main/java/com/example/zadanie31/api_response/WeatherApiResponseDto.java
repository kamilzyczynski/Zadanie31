package com.example.zadanie31.api_response;

import lombok.Data;

import java.util.List;

@Data
public class WeatherApiResponseDto {
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private long id;
    private String name;
    private int cod;
}
