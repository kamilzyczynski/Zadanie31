package com.example.zadanie31.openweatherapi;

import lombok.Data;

@Data
class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;

}
