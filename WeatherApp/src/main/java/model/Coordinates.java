package model;

import org.json.JSONException;
import org.json.JSONObject;

public class Coordinates {
	public final double latitude;
	public final double longitude;
	
	
	public Coordinates(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Coordinates [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	public JSONObject toJSON() throws JSONException {

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("latitude", latitude);
        jsonObj.put("longitude", longitude);
        return jsonObj;
    }
}
