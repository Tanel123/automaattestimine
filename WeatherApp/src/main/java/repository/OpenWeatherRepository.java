package repository;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Coordinates;
import model.CurrentWeatherReport;
import model.OneDayMaxMinTemp;
import model.ThreeDaysWeatherReport;
import model.WeatherRequest;
import utility.HttpConnection;
import utility.ThreeDaysWeatherQuery;

public class OpenWeatherRepository implements WeatherRepository{  
	public static String OW_MAIN_OBJ = "main";
	public static String OW_DT_OBJ = "dt";
	public static String OW_TEMP_OBJ = "temp";
	
	public static JSONObject tomorrowWeatherInfo;
	public static JSONObject dayAfterTomorrowWeatherInfo;
	public static JSONObject twoDaysAfterTomorrowWeatherInfo;
	
	public static ArrayList<Double> tomorrowTempList = new ArrayList<Double>();
    public static ArrayList<Double> dayAfterTomorrowTempList = new ArrayList<Double>();
    public static ArrayList<Double> twoDaysAfterTomorrowTempList = new ArrayList<Double>();
    
	
    @Override
    public CurrentWeatherReport getCurrentWeather(WeatherRequest request) throws Exception{
		try {
			return getCurrentWeatherReport(request);
		} catch(Exception e){
			throw new Exception("Problem with CurrentWeatherReport");
		}	
    }

    
    
    @Override
    public ThreeDaysWeatherReport getThreeDaysWeather(WeatherRequest request) throws Exception {    	
    	try{
    		return getThreeDaysWeatherReport(request);
    	}catch(Exception e){
    		throw new Exception("Problem with ThreeDaysWeatherReport");
    	}
    }
    
    
    
    private CurrentWeatherReport getCurrentWeatherReport(WeatherRequest request) throws ClientProtocolException, IOException, ParseException, JSONException{
    	HttpResponse data = HttpConnection.getHttpResponse("http://api.openweathermap.org/data/2.5/weather?q="+request.cityName+",EE&APPID=1a8a68a7512dc21390d787008026df5e&units="+request.unit);
    	JSONObject jsonObj = HttpConnection.convertResponseToJsonObject(data);
    	Coordinates coord = new Coordinates(jsonObj.getJSONObject("coord").getDouble("lon"), 
    										jsonObj.getJSONObject("coord").getDouble("lat"));
        CurrentWeatherReport currentWeatherReport = new CurrentWeatherReport(jsonObj.getString("name"), coord, jsonObj.getJSONObject("main").getInt("temp")); 
    	return currentWeatherReport;   	
    }
    
    
    private ThreeDaysWeatherReport getThreeDaysWeatherReport(WeatherRequest request) throws ClientProtocolException, IOException, ParseException, JSONException{
    	
    	HttpResponse data = HttpConnection.getHttpResponse("http://api.openweathermap.org/data/2.5/forecast?q="+request.cityName+",EE&APPID=1a8a68a7512dc21390d787008026df5e&units="+request.unit);
    	JSONObject jsonObj = HttpConnection.convertResponseToJsonObject(data);
    	
    	JSONArray jsonWeatherArray = jsonObj.getJSONArray("list");
    	ThreeDaysWeatherQuery.findTemperaturestForThreeDays(jsonWeatherArray);
 
    	OneDayMaxMinTemp tomorrowMaxMinTemp = new OneDayMaxMinTemp(ThreeDaysWeatherQuery.getMaxTemp(tomorrowTempList), 
    			   ThreeDaysWeatherQuery.getMinTemp(tomorrowTempList));
    	
    	OneDayMaxMinTemp dayAfterTomorrowMaxMinTemp = new OneDayMaxMinTemp(ThreeDaysWeatherQuery.getMaxTemp(dayAfterTomorrowTempList), 
			       ThreeDaysWeatherQuery.getMinTemp(dayAfterTomorrowTempList));
    	
    	OneDayMaxMinTemp twoDaysAfterTomorrowMaxMinTemp = new OneDayMaxMinTemp(ThreeDaysWeatherQuery.getMaxTemp(twoDaysAfterTomorrowTempList), 
			       ThreeDaysWeatherQuery.getMinTemp(twoDaysAfterTomorrowTempList));   	
    	
    	OneDayMaxMinTemp[] threeDaysTemperatureList = new OneDayMaxMinTemp[3];
    	threeDaysTemperatureList[0] = tomorrowMaxMinTemp;
    	threeDaysTemperatureList[1] = dayAfterTomorrowMaxMinTemp;
    	threeDaysTemperatureList[2] = twoDaysAfterTomorrowMaxMinTemp;
    	
    	Coordinates coord = new Coordinates(jsonObj.getJSONObject("city").getJSONObject("coord").getDouble("lon"), 
				jsonObj.getJSONObject("city").getJSONObject("coord").getDouble("lat"));
    	
    	ThreeDaysWeatherReport threeDaysWeatherReport = new ThreeDaysWeatherReport(jsonObj.getJSONObject("city").getString("name"), coord, threeDaysTemperatureList);
    	
    	return threeDaysWeatherReport;
	      
    }
    
    public static void addTemperaturesToList(JSONObject oneDayWeatherInfo, ArrayList<Double> oneDayTemperaturesList) throws JSONException{
    	oneDayTemperaturesList.add(oneDayWeatherInfo.getDouble(OpenWeatherRepository.OW_TEMP_OBJ));
    }
	
}
