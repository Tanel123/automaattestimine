package model;


public class CurrentWeatherReport{
	
	public final String cityName;
	public final Coordinates coordinates;
	public final int currentTemperature;
	
    public CurrentWeatherReport(String cityName, Coordinates coordinates, int currentTemperature) {
    	this.cityName = cityName;
		this.coordinates = coordinates;
        this.currentTemperature = currentTemperature;
    }

}
