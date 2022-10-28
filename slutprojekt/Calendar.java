package slutprojekt;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Calendar {
	
	 /*I Import the TemporalAdjusters class to call the previousOrSame method so that my calendar looks up Monday every week */

	static LocalDate date = LocalDate.now();
	static LocalDate weekDay = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

}
