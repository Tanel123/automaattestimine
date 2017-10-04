package repository;

import model.CurrentWeatherReport;
import model.ThreeDaysWeatherReport;
import model.WeatherRequest;

public interface WeatherRepository {
    CurrentWeatherReport getCurrentWeather(WeatherRequest request) throws Exception;

    ThreeDaysWeatherReport getThreeDaysWeather(WeatherRequest request) throws Exception;
}
