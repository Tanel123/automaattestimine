package utility;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.json.JSONException;
import org.json.JSONObject;

import model.CurrentWeatherReport;
import model.ThreeDaysWeatherReport;

public class OutputWriter {
	
	public void writeToFile(CurrentWeatherReport currentWeatherReport, ThreeDaysWeatherReport threeDaysWeatherReport, String path) throws JSONException{	 
	        Writer writer = null;

	        try {
	            writer = new BufferedWriter(new OutputStreamWriter(
	                  new FileOutputStream(path, true), "utf-8"));
	  	        
	            JSONObject WeatherInfoJsonObj = currentWeatherReport.toJSON();
	            
	            ThreeDaysWeatherJsonHelper maxMinTempJsonArrayHelper = new ThreeDaysWeatherJsonHelper();	            
	            WeatherInfoJsonObj.put("threeDaysWeather", maxMinTempJsonArrayHelper.getThreeDaysWeatherMaxMinTempJsonArray(threeDaysWeatherReport));
	    		
	    		writer.write(WeatherInfoJsonObj.toString(4));
	    		writer.write('\n');
            
	            
	        } catch (IOException ex) {
	        	ex.printStackTrace();
	        	
	        } finally {
	           try {writer.close();} catch (Exception ex) {ex.printStackTrace();}
	        }
	}
}

