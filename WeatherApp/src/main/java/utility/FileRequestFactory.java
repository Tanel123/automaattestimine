package utility;

import model.WeatherRequest;

public class FileRequestFactory {
	
	public WeatherRequest[] createRequestsUsingInputFile() throws Exception{
		InputReader inputReader = new InputReader();
	    WeatherRequest[] requestsList = inputReader.makeRequestListFromFile(Constants.INPUT_FILE);
	    return requestsList;
	}
}
