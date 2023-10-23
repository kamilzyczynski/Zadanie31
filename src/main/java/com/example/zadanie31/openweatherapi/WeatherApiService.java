package com.example.zadanie31.openweatherapi;

import com.example.zadanie31.CityNotFoundException;
import com.example.zadanie31.WeatherDisplayDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherApiService {
    private String openWeatherApiKey;

    public WeatherApiService(@Value("${my.app.apiKey}") String openWeatherApiKey) {
        this.openWeatherApiKey = openWeatherApiKey;
    }

    public WeatherDisplayDto getWeatherInCity(String city) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + openWeatherApiKey + "&units=metric";

            WeatherApiResponseDto apiResponse = restTemplate.getForObject(url, WeatherApiResponseDto.class);
            return weatherToDisplayMapper(apiResponse);

        } catch (Exception e) {
            throw new CityNotFoundException();
        }
    }

    private WeatherDisplayDto weatherToDisplayMapper(WeatherApiResponseDto weatherApiResponseDto) {
        return WeatherDisplayDto.builder()
                .cityName(weatherApiResponseDto.getName())
                .visibility(weatherApiResponseDto.getVisibility())
                .temp(weatherApiResponseDto.getMain().getTemp())
                .pressure(weatherApiResponseDto.getMain().getPressure())
                .humidity(weatherApiResponseDto.getMain().getHumidity())
                .windSpeed(weatherApiResponseDto.getWind().getSpeed())
                .build();
    }
}
