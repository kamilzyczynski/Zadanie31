package com.example.zadanie31.openweatherapi;

import lombok.Data;

@Data
class Wind {
    private double speed;
    private int deg;
    private double gust;
}
