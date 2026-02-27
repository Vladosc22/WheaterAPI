package com.vlad.weather.WeatherAPI.dto;

import lombok.Data;
import java.util.List;

@Data
public class WeatherResponseDto {

    private String name;
    private Main main;
    private List<Weather> weather;

    @Data
    public static class Main {
        private double temp;
        private int humidity;
    }

    @Data
    public static class Weather {
        private String description;
    }
}