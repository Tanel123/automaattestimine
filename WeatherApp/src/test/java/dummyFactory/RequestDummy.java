package dummyFactory;

import model.WeatherRequest;
import utility.Constants;

public class RequestDummy {
	private final String cityName = "Tallinn";
	
	public WeatherRequest[] createWeatherRequestDummy(){
		WeatherRequest userRequest = new WeatherRequest(cityName, Constants.UNIT);
	    WeatherRequest[] requestsList = new WeatherRequest[1];
	    requestsList[0] = userRequest;
	    return requestsList;
	}
}
