package dummyFactory;

import model.Coordinates;
import model.CurrentWeatherReport;
import model.OneDayMaxMinTemp;
import model.ThreeDaysWeatherReport;

public class ResponceDummy {
	private final String cityName = "Tallinn";
	
	public CurrentWeatherReport createCurrentWeatherDummy(){
	    CurrentWeatherReport currentWeatherReportDummy = new CurrentWeatherReport(cityName, createCoordinatesDummy(), -1);
	    return currentWeatherReportDummy;
	}
	
	public ThreeDaysWeatherReport createThreeDaysWeatherReportDummy(){
	    OneDayMaxMinTemp dayOneMaxMin = new OneDayMaxMinTemp(2.1, -1);
	    OneDayMaxMinTemp dayTwoMaxMin = new OneDayMaxMinTemp(2.1, -2);
	    OneDayMaxMinTemp dayThreeMaxMin = new OneDayMaxMinTemp(2.1, -3);
		OneDayMaxMinTemp[] threeDaysTemperatureList = new OneDayMaxMinTemp[3];
		threeDaysTemperatureList[0] = dayOneMaxMin;
		threeDaysTemperatureList[1] = dayTwoMaxMin;
		threeDaysTemperatureList[2] = dayThreeMaxMin;
		ThreeDaysWeatherReport threeDaysWeatherReportDummy = new ThreeDaysWeatherReport(cityName, createCoordinatesDummy(), threeDaysTemperatureList);
		return threeDaysWeatherReportDummy;
	}
	
	private Coordinates createCoordinatesDummy(){
		Coordinates coordinates = new Coordinates(25.96, 59.26);
		return coordinates;
	}

	public String getCityName() {
		return cityName;
	}
}

