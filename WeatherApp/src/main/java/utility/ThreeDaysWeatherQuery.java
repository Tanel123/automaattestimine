package utility;

import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThreeDaysWeatherQuery {
	public static ArrayList<Double> tomorrowTempList = new ArrayList<Double>();
    public static ArrayList<Double> dayAfterTomorrowTempList = new ArrayList<Double>();
    public static ArrayList<Double> twoDaysAfterTomorrowTempList = new ArrayList<Double>();
    
    public static void findTemperaturesForThreeDays(JSONArray jsonWeatherArray) throws JSONException{
	      for(int i=0; i < jsonWeatherArray.length(); i++){ 
	    	  JSONObject j = (JSONObject) jsonWeatherArray.get(i);
	    	  if(j.getInt("dt") >= UnixTimeCalculator.getStartTimeOfDayInUnix(1) && j.getInt("dt") < UnixTimeCalculator.getStartTimeOfDayInUnix(2)){
	    		  JSONObject main = (JSONObject) j.getJSONObject("main");
	    		  tomorrowTempList.add(main.getDouble("temp"));
	    	  }else if(j.getInt("dt") >= UnixTimeCalculator.getStartTimeOfDayInUnix(2) && j.getInt("dt") < UnixTimeCalculator.getStartTimeOfDayInUnix(3)){
	    		  JSONObject main2 = (JSONObject) j.getJSONObject("main");
	    		  dayAfterTomorrowTempList.add(main2.getDouble("temp"));
	    	  }else if(j.getInt("dt") >= UnixTimeCalculator.getStartTimeOfDayInUnix(3) && j.getInt("dt") < UnixTimeCalculator.getStartTimeOfDayInUnix(4)){
	    		  JSONObject main3 = (JSONObject) j.getJSONObject("main");
	    		  twoDaysAfterTomorrowTempList.add(main3.getDouble("temp"));
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

