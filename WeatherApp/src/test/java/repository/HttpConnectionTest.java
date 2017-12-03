package repository;

import static org.junit.Assert.*;

import org.apache.http.HttpResponse;

import utility.HttpConnection;

import org.junit.Test;


public class HttpConnectionTest {
	private final int HTTP_OK_CODE = 200;
	private final String CURRENT_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn,EE&APPID=1a8a68a7512dc21390d787008026df5e&units=metric";
	private final String THREE_DAYS_WEATHER_URL = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,EE&APPID=1a8a68a7512dc21390d787008026df5e&units=metric";

	@Test
	public void testConnectionForCurrentWeather() {
		try{
			HttpResponse httpRes = HttpConnection.getHttpResponse(CURRENT_WEATHER_URL);
			int responseCode = httpRes.getStatusLine().getStatusCode();
			assertEquals(responseCode, HTTP_OK_CODE);
		} catch(Exception e){
			fail("Failed to make connection with API for current weather data");
		}
	}
	
	@Test
	public void testConnectionForThreeDaysWeather() {
		try{
			HttpResponse httpRes = HttpConnection.getHttpResponse(THREE_DAYS_WEATHER_URL);
			int responseCode = httpRes.getStatusLine().getStatusCode();
			assertEquals(responseCode, HTTP_OK_CODE);
		} catch(Exception e){
			fail("Failed to make a connection with API for three days weather data");
		}
	}
}
