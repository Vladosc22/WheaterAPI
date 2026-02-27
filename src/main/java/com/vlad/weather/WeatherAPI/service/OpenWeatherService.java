package com.vlad.weather.WeatherAPI.service;

import com.vlad.weather.WeatherAPI.dto.WeatherResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class OpenWeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${openweather.base.url}")
    private String baseUrl;

    @Value("${openweather.api.key}")
    private String apiKey;

    public WeatherResponseDto getWeather(String city) {

        String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);

        String url = String.format(
                "%s?q=%s&appid=%s&units=metric",
                baseUrl,
                encodedCity,
                apiKey
        );

        return restTemplate.getForObject(url, WeatherResponseDto.class);
    }
}