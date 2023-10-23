package com.example.zadanie31;

import com.example.zadanie31.openweatherapi.WeatherApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherApiController {
    private final WeatherApiService weatherApiService;

    public WeatherApiController(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    @GetMapping("/displayWeather")
    public String displayWeather(@RequestParam("cityName") String cityName, Model model) {
        model.addAttribute("weather", weatherApiService.getWeatherInCity(cityName));
        return "displayWeather";
    }
}
