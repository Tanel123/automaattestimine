package ee.ttu.forecast.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ee.ttu.forcast.connection.WeatherApi;

public class WeatherApiTests {
 
	WeatherApi weatherApi;
	
	@Before
	public void setUp() throws Exception {
		weatherApi = new WeatherApi();
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetCurrentTemperature(){
		assertNotNull("getCurrentTemperature method returned value should not be null", 
				weatherApi.getCurrentTemperature());
		assertTrue("getCurrentTemperature method returned value should be lower than 70", 
				weatherApi.getCurrentTemperature()<70);
		assertTrue("getCurrentTemperature method returned value should be higher than -100", 
				weatherApi.getCurrentTemperature()>-100);
	}
	
	@Test
	public void testFindHighestTemperature(){
		assertNotNull("findHighestTemperature method returned value should not be null", 
				weatherApi.findHighestTemperature());
		assertTrue("findHighestTemperatur method returned value should be lower than 70", 
				weatherApi.findHighestTemperature()<70);
		assertTrue("findHighestTemperatur method returned value should be higher than -90", 
				weatherApi.findHighestTemperature()>-90);
	}
	
	@Test
	public void testFindLowestTemperature(){
		assertNotNull("findLowestTemperature method returned value should not be null", 
				weatherApi.findLowestTemperature());
		assertTrue("findLowestTemperature method returned value should be lower than 60", 
				weatherApi.findLowestTemperature()<60);
		assertTrue("findLowestTemperature method returned value should be higher than -100", 
				weatherApi.findLowestTemperature()>-100);
	}
	
	@Test
	public void testHigestTemperatureIsHigherThanLowest(){
		assertTrue("Highest temp must be higher than lowest temp", 
				weatherApi.findHighestTemperature()>weatherApi.findLowestTemperature());
	}
	
	@Test
	public void testGetCoordinates(){
		assertNotNull("getCoordinates method returned value should not be null", 
				weatherApi.getCoordinates());
		assertTrue("getCoordinates method returned value should include colon", 
				weatherApi.getCoordinates().indexOf(":") != -1);
		assertTrue("getCoordinates method returned value should have seven caracters", 
				weatherApi.getCoordinates().length()==7);
		assertTrue("getCoordinates method returned value should have number at places indexed as 0,1,2", 
				weatherApi.getCoordinates().substring(0, 2).matches("\\d+"));
		assertTrue("getCoordinates method returned value should have number at places indexed as 4,5,5", 
				weatherApi.getCoordinates().substring(5, 7).matches("\\d+"));
	}
	
	@Test
	public void testGetCurrentWeather(){		
		assertNotNull("getCurrentWeather method returned value should not be null", 
				weatherApi.getCurrentWeather());
		assertTrue("Timestamp from current weather json must be smaller than current moment timestamp", 
				weatherApi.getCurrentTimestamp()>weatherApi.getCurrentWeatherTimestamp());
		assertTrue("getCurrentWeather method returned value must start with '{'", 
				weatherApi.getCurrentWeather().startsWith("{"));
		assertTrue("getCurrentWeather method returned value must end with '{'", 
				weatherApi.getCurrentWeather().endsWith("}"));
	}
	
	@Test
	public void testGetThreeNextDaysWeather(){
		assertNotNull("getThreeNextDaysWeather method returned value should not be null", 
				weatherApi.getThreeNextDaysWeather());
		assertTrue("getThreeNextDaysWeather method returned value must start with '{'", weatherApi.getThreeNextDaysWeather().startsWith("{"));
		assertTrue(" method returned value must end with '{'", 
				weatherApi.getThreeNextDaysWeather().endsWith("}"));
	}
	
}
