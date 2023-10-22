package com.example.zadanie31;

import com.example.zadanie31.apiresponse.WeatherApiResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class WeatherApiController {
    private final WeatherApiService weatherApiService;

    public WeatherApiController(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    @PostMapping("/checkWeather")
    public String checkWeather(@RequestParam String cityName) {
        return UriComponentsBuilder.fromPath("/displayWeather")
                .scheme("redirect")
                .queryParam("cityName", cityName)
                .build().toString();
    }

    @GetMapping("/displayWeather")
    public String displayWeather(@RequestParam("cityName") String cityName, Model model) {
        WeatherApiResponseDto weatherInCity = weatherApiService.getWeatherInCity(cityName);
        model.addAttribute("weather", weatherApiService.weatherToDisplayMapper(weatherInCity));
        return "displayWeather";
    }
}
