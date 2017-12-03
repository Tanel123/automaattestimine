package model;

import org.json.JSONException;
import org.json.JSONObject;

public class OneDayMaxMinTemp {
	public final double maxTemperature;
	public final double minTemperature;
	
	public OneDayMaxMinTemp(double maxTemperature, double minTemperature) {
		super();
		this.maxTemperature = maxTemperature;
		this.minTemperature = minTemperature;
	}

	@Override
	public String toString() {
		return "OneDayMaxMinTemp [maxTemperature=" + maxTemperature + ", minTemperature=" + minTemperature + "]";
	}
	
	
	public JSONObject toJSON() throws JSONException {

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("maxTemperature", maxTemperature);
        jsonObj.put("minTemperature", minTemperature);
        return jsonObj;
    }

	public double getMaxTemperature() {
		return maxTemperature;
	}

	public double getMinTemperature() {
		return minTemperature;
	}
	
}
