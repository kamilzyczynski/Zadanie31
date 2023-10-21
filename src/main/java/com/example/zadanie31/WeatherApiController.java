package com.example.zadanie31;

import com.example.zadanie31.api_response.WeatherApiResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WeatherApiController {
    private final WeatherApiService weatherApiService;

    public WeatherApiController(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    @PostMapping("/checkWeather")
    public String checkWeather(@RequestParam String cityName, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("cityName", cityName);
        return "redirect:/displayWeather";
    }

    @GetMapping("/displayWeather")
    public String displayWeather(@ModelAttribute("cityName") String cityName, Model model) {
        WeatherApiResponseDto weatherInCity = weatherApiService.getWeatherInCity(cityName);
        model.addAttribute("weather", weatherApiService.weatherToDisplayMapper(weatherInCity));
        return "displayWeather";
    }
}
