package utility;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class UnixTimeCalculator {
	
	
	public static long getStartTimeOfDayInUnix(int nrOfDaysFromCurrentDay){
		Date dt = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(dt.toInstant(),ZoneId.systemDefault()).plusDays(nrOfDaysFromCurrentDay);
		ldt = ldt.with(LocalTime.MIDNIGHT);
		Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		long timeInUnix = (out.getTime()/1000) + 10800;
		return timeInUnix;
	}

}
