package utility;

import java.util.Scanner;

import model.WeatherRequest;
import dummyFactory.RequestDummy;

public class RequestFactory {
	private Scanner scanner;
	
	public WeatherRequest[] askUserDecisionForRequest() throws Exception{
				
		try{			
			System.out.println("To insert city name from console insert 'C', "
					+ "To read city name from input.txt file insert 'R', "
					+ "To use dummy insert 'D': ");
			scanner = new Scanner(System.in);
			String decision = scanner.nextLine();
			
			if(decision.equalsIgnoreCase("C")){				
				ScannerRequestFactory scannerRequest = new ScannerRequestFactory();
				WeatherRequest[] requests = scannerRequest.createRequest();
				return requests;
				
			}else if(decision.equalsIgnoreCase("R")){
				FileRequestFactory fileRequest = new FileRequestFactory();
				WeatherRequest[] requests = fileRequest.createRequestsUsingInputFile();
				return requests;
				
			}else if(decision.equalsIgnoreCase("D")){
				RequestDummy dummyRequest = new RequestDummy();
				WeatherRequest[] requests = dummyRequest.createWeatherRequestDummy();
				return requests;
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
