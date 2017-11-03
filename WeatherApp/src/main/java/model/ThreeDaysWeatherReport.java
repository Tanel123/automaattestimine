package model;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeDaysWeatherReport{
	public final String cityName;
	public final Coordinates coordinates;
	public final OneDayMaxMinTemp[] threeDaysWeatherList;
	
	public ThreeDaysWeatherReport(String cityName, Coordinates coordinates, OneDayMaxMinTemp[] threeDaysWeatherList) {
		super();
		this.cityName = cityName;
		this.coordinates = coordinates;
		this.threeDaysWeatherList = threeDaysWeatherList;
	}

	@Override
	public String toString() {
		return "ThreeDaysWeatherReport [cityName=" + cityName + ", coordinates=" + coordinates
				+ ", threeDaysWeatherList=" + Arrays.toString(threeDaysWeatherList) + "]";
	}
	
}
