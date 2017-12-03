package utility;

import com.google.gson.Gson;

import model.WeatherRequest;
import java.io.FileReader;
import java.io.Reader;

public class InputReader {

	 public WeatherRequest[] makeRequestListFromFile(String INPUT_FILE) throws Exception {
	        try (Reader reader = new FileReader(INPUT_FILE)) {
	            Gson gson = new Gson();
	            WeatherRequest[] requestsList = gson.fromJson(reader, WeatherRequest[].class);
	            return requestsList;
	        }catch(Exception e){
				throw new Exception("Making WeatherRequest list from file failed");
			}
	    }
} 
