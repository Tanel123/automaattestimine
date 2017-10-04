package repository;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import model.Coordinates;
import model.CurrentWeatherReport;
import model.ThreeDaysWeatherReport;
import model.WeatherRequest;
import utility.HttpConnection;

public class OpenWeatherRepository implements WeatherRepository{
	
    @Override
    public CurrentWeatherReport getCurrentWeather(WeatherRequest request) throws Exception{
		try {
			return getCurrentWeatherReport(request);
		} catch(Exception e){
			throw new Exception("Problem with WeatherReport");
		}	
    }

    @Override
    public ThreeDaysWeatherReport getThreeDaysWeather(WeatherRequest request){    	
    	return getThreeDaysWeatherReport(request);
    }
    
    private CurrentWeatherReport getCurrentWeatherReport(WeatherRequest request) throws ClientProtocolException, IOException, ParseException, JSONException{
    	HttpResponse data = HttpConnection.getHttpResponse("http://api.openweathermap.org/data/2.5/weather?q="+request.cityName+"&APPID=1a8a68a7512dc21390d787008026df5e&units="+request.unit);
    	JSONObject jsonObj = HttpConnection.convertResponseToJsonObject(data);
    	Coordinates coord = new Coordinates(jsonObj.getJSONObject("coord").getDouble("lon"), 
    										jsonObj.getJSONObject("coord").getDouble("lat"));
        CurrentWeatherReport currentWeatherReport = new CurrentWeatherReport(jsonObj.getString("name"), coord, jsonObj.getJSONObject("main").getInt("temp")); 
    	return currentWeatherReport;   	
    }
    
    private ThreeDaysWeatherReport getThreeDaysWeatherReport(WeatherRequest request){
    	//notImplemented
    }


}
