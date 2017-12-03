package utility;

import java.util.Scanner;

import model.WeatherRequest;


public class ScannerRequestFactory {
	private Scanner scanner;
	
	public WeatherRequest[] createRequest(){		
		scanner = new Scanner(System.in);
		System.out.println("Enter city name: ");
		String cityname = scanner.nextLine();
		WeatherRequest userRequest = new WeatherRequest(cityname, Constants.UNIT);
	    WeatherRequest[] requestsList = new WeatherRequest[1];
	    requestsList[0] = userRequest;
	    return requestsList;    
	}
}