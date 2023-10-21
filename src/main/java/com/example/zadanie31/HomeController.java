package com.example.zadanie31;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private WeatherApiService weatherApiService;

    public HomeController(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
