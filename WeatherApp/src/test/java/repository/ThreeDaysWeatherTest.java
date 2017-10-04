package repository;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.ThreeDaysWeather;
import model.ThreeDaysWeatherReport;
import model.WeatherRequest;

public class ThreeDaysWeatherTest {
    private static ThreeDaysWeatherReport report;
    private static WeatherRequest request;

	@Before
	public void setUp() throws Exception {
		try{
			request = new WeatherRequest("Tallinn", "metric");
			OpenWeatherRepository repository = new OpenWeatherRepository();
			report = repository.getThreeDaysWeather(request);
		}catch (Exception e){
			fail("Cause of failure: " + e.getMessage());
		}	
	}
	
	@After
	public void tearDown() throws Exception {}
	
	@Test
	public void testLatitude(){
		assertTrue(report.coordinates.latitude >-90);
		assertTrue(report.coordinates.latitude < 90);
	}
	
	@Test
	public void testLongitude(){
		assertTrue(report.coordinates.longitude > -180);
		assertTrue(report.coordinates.longitude < 180);
	}
	
	@Test
	public void testIfResponseAndRequestCityAreEqual(){
		assertEquals(request.cityName, report.cityName);
	}
	
	@Test
	public void testIfWeatherForThreeDaysIsReturned(){
		assertEquals(3, report.threeDaysWeather.length);
	}
	
	@Test
	public void TestIfHigestTemperatureIsHigherThanLowestForEachDay(){
		ThreeDaysWeather[] tdw = report.threeDaysWeather;
		for(ThreeDaysWeather t:tdw){
			assertTrue(t.maxTemperature > t.minTemperature);
		}	
	}
	
	@Test
	public void TestHigestTemperatures(){
		ThreeDaysWeather[] tdw = report.threeDaysWeather;
		for(ThreeDaysWeather t:tdw){
			assertTrue(t.maxTemperature < 70);
			assertTrue(t.maxTemperature > -100);
		}
	}
	
	@Test
	public void TestLowestTemperatures(){
		ThreeDaysWeather[] tdw = report.threeDaysWeather;
		for(ThreeDaysWeather t:tdw){
			assertTrue(t.minTemperature < 70);
			assertTrue(t.minTemperature > -100);
		}
	}
	
	/**
	@Test
	public void testIfTheDatesAreFollowingEachother(){
		ThreeDaysWeather[] tdw = report.threeDaysWeather;
		for(ThreeDaysWeather t:tdw){			
		} 
	**/
}
	



