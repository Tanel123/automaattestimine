package model;

public class ThreeDaysWeatherReport{
	public final String cityName;
	public final Coordinates coordinates;
	public final ThreeDaysWeather[] threeDaysWeather;
	
	public ThreeDaysWeatherReport(String cityName, Coordinates coordinates, ThreeDaysWeather[] threeDaysWeather){
		this.cityName = cityName;
		this.coordinates = coordinates;
		this.threeDaysWeather = threeDaysWeather;
	}

}
