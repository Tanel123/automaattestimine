package utility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.ThreeDaysWeatherReport;

public class ThreeDaysWeatherJsonHelper {	
	
	public JSONArray getThreeDaysWeatherMaxMinTempJsonArray(ThreeDaysWeatherReport threeDaysWeatherReport) throws JSONException{
	    JSONObject threeDaysWeatherReportJsonObj = threeDaysWeatherReport.toJSON();
	    JSONArray threeDaysWeatherJson = threeDaysWeatherReportJsonObj.getJSONArray("threeDaysWeather");
	    return threeDaysWeatherJson;
	}
}
