package com.example.zadanie31;

import com.example.zadanie31.api_response.WeatherApiResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherApiService {

    public WeatherApiResponseDto getWeatherInCity(String city) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=407fb443f6946a53f2123b6791efde13&units=metric";

            return restTemplate.getForObject(url, WeatherApiResponseDto.class);
        } catch (Exception e) {
            throw new CityNotFoundException();
        }
    }

    public WeatherDisplayDto weatherToDisplayMapper(WeatherApiResponseDto weatherApiResponseDto) {
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
