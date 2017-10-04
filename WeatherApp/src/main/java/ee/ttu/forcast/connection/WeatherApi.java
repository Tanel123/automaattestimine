package ee.ttu.forcast.connection;

public class WeatherApi {
	private int currentTimestamp;
	private int currentWeatherTimestamp;
 
	public WeatherApi() {
		super();
	}
	
	public int getCurrentTimestamp() {
		return currentTimestamp;
	}

	public void setCurrentTimestamp(int currentTimestamp) {
		this.currentTimestamp = currentTimestamp;
	}

	public int getCurrentWeatherTimestamp() {
		return currentWeatherTimestamp;
	}

	public void setCurrentWeatherTimestamp(int currentWeatherTimestamp) {
		this.currentWeatherTimestamp = currentWeatherTimestamp;
	}

	public String getCurrentWeather() {
    	return "json";
    }
    
    public String getThreeNextDaysWeather(){
    	return "json";
    }
    
    public int getCurrentTemperature(){    	
    	return 10;
    }
    
    public int findHighestTemperature(){
    	return 11;
    }
    
    public int findLowestTemperature(){
    	return 10;
    }
    
    public String getCoordinates(){
    	return "xxx:yyy";
    }
    
    
}
