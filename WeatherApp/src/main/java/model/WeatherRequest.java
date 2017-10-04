package model;

public class WeatherRequest {
	
    public final String cityName;
    public final String unit;


    public WeatherRequest(String cityName, String unit) {
        this.cityName = cityName;
        this.unit = unit;
    }
	
}
