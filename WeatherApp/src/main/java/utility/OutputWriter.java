package utility;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import model.CurrentWeatherReport;
import model.ThreeDaysWeatherReport;

public class OutputWriter {
	
	public static void writeToFile(Object report){	
	    if(report instanceof CurrentWeatherReport){  
	        Writer writer = null;

	        try {
	            writer = new BufferedWriter(new OutputStreamWriter(
	                  new FileOutputStream("C:/Users/Tanel/Documents/GitHub/automaattestimine/output.txt", true), "utf-8"));
	            
	            writer.write(report.toString());
	            writer.write('\n');
	            
	        } catch (IOException ex) {
	        	ex.printStackTrace();
	        	
	        } finally {
	           try {writer.close();} catch (Exception ex) {ex.printStackTrace();}
	        }
	    }  
	    else if(report instanceof ThreeDaysWeatherReport){  
	       Writer writer = null;

	       try {
	           writer = new BufferedWriter(new OutputStreamWriter(
	                 new FileOutputStream("C:/Users/Tanel/Documents/GitHub/automaattestimine/output.txt", true), "utf-8"));
	           
	           writer.write(report.toString());
	           writer.write('\n');
	           
	       } catch (IOException ex) {
	       	ex.printStackTrace();
	       	
	       } finally {
	          try {writer.close();} catch (Exception ex) {ex.printStackTrace();}
	       }
	   }
	}
}

