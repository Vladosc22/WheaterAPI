package com.vlad.weather.WeatherAPI.controller;
import com.vlad.weather.WeatherAPI.dto.WeatherResponseDto;
import com.vlad.weather.WeatherAPI.service.OpenWeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin
public class WeatherController {

    private final OpenWeatherService service;

    public WeatherController(OpenWeatherService service) {
        this.service = service;
    }

    @GetMapping
    public WeatherResponseDto getWeather(@RequestParam String city) {
        return service.getWeather(city);
    }
}