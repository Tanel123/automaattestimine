package model;

import org.json.JSONException;
import org.json.JSONObject;

public class CurrentWeatherReport{
	
	public final String cityName;
	public final Coordinates coordinates;
	public final int currentTemperature;

	public CurrentWeatherReport(String cityName, Coordinates coordinates, int currentTemperature) {
    	this.cityName = cityName;
		this.coordinates = coordinates;
        this.currentTemperature = currentTemperature;
    }

    @Override
	public String toString() {
		return "CurrentWeatherReport [cityName=" + cityName + ", coordinates=" + coordinates + ", currentTemperature="
				+ currentTemperature + "]";
	}
    
    
	public JSONObject toJSON() throws JSONException {

        JSONObject jsonObj = new JSONObject();        
        jsonObj.put("cityName", cityName);
        jsonObj.put("coordinates", coordinates.toJSON());
		jsonObj.put("currentTemperature", currentTemperature);
        return jsonObj;
    }
}
