package repository;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import model.CurrentWeatherReport;
import model.ThreeDaysWeatherReport;
import model.WeatherRequest;

public interface WeatherRepository {
    CurrentWeatherReport getCurrentWeather(WeatherRequest request) throws Exception;

    ThreeDaysWeatherReport getThreeDaysWeather(WeatherRequest request)throws Exception;
}
