package utility;

import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import repository.OpenWeatherRepository;

public class ThreeDaysWeatherQuery {
    
    public static void findTemperaturestForThreeDays(JSONArray jsonWeatherArray) throws JSONException{
	      for(int i=0; i < jsonWeatherArray.length(); i++){
	    	  
	    	  JSONObject j = (JSONObject) jsonWeatherArray.get(i);
	    	  
	    	  if(j.getInt(OpenWeatherRepository.OW_DT_OBJ) >= UnixTimeCalculator.getStartTimeOfDayInUnix(1) 
	    			  && j.getInt(OpenWeatherRepository.OW_DT_OBJ) < UnixTimeCalculator.getStartTimeOfDayInUnix(2)){
	    		  
	    		  OpenWeatherRepository.tomorrowWeatherInfo = (JSONObject) j.getJSONObject(OpenWeatherRepository.OW_MAIN_OBJ);
	    		  OpenWeatherRepository.addTemperaturesToList(OpenWeatherRepository.tomorrowWeatherInfo, 
	    				  OpenWeatherRepository.tomorrowTempList);
	    		  
	    	  }else if(j.getInt(OpenWeatherRepository.OW_DT_OBJ) >= UnixTimeCalculator.getStartTimeOfDayInUnix(2) 
	    			  && j.getInt(OpenWeatherRepository.OW_DT_OBJ) < UnixTimeCalculator.getStartTimeOfDayInUnix(3)){
	    		  
	    		  OpenWeatherRepository.dayAfterTomorrowWeatherInfo = (JSONObject) j.getJSONObject(OpenWeatherRepository.OW_MAIN_OBJ);
	    		  OpenWeatherRepository.addTemperaturesToList(OpenWeatherRepository.dayAfterTomorrowWeatherInfo, 
	    				  OpenWeatherRepository.dayAfterTomorrowTempList);
	    		  
	    	  }else if(j.getInt(OpenWeatherRepository.OW_DT_OBJ) >= UnixTimeCalculator.getStartTimeOfDayInUnix(3) 
	    			  && j.getInt(OpenWeatherRepository.OW_DT_OBJ) < UnixTimeCalculator.getStartTimeOfDayInUnix(4)){
	    		  
	    		  OpenWeatherRepository.twoDaysAfterTomorrowWeatherInfo = (JSONObject) j.getJSONObject(OpenWeatherRepository.OW_MAIN_OBJ);
	    		  OpenWeatherRepository.addTemperaturesToList(OpenWeatherRepository.twoDaysAfterTomorrowWeatherInfo, 
	    				  OpenWeatherRepository.twoDaysAfterTomorrowTempList);
	    	  }
	      }
    }
    
    public static double getMaxTemp(ArrayList<Double> TempList){
		double maxTemp = Collections.max(TempList);
    	return maxTemp;
    }
    
    public static double getMinTemp(ArrayList<Double> TempList){
		double maxTemp = Collections.min(TempList);
    	return maxTemp;
    }

}

