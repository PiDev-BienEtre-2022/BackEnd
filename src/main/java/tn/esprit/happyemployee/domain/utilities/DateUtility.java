package tn.esprit.happyemployee.domain.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtility {

	public Date getFirstDateOfWeek(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		String dateInString = dt.toString();
		try {
			Date d = sdf.parse(dateInString);
			LocalDate date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate startDateOfTheWeek = date;
		    while (startDateOfTheWeek.getDayOfWeek() != DayOfWeek.MONDAY) {
		    	startDateOfTheWeek = startDateOfTheWeek.minusDays(1);
		    }
			return Date.from(startDateOfTheWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Date getLastDateOfWeek(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		String dateInString = dt.toString();
		try {
			Date d = sdf.parse(dateInString);
			LocalDate date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate endDateOfTheWeek = date;
			while (endDateOfTheWeek.getDayOfWeek() != DayOfWeek.SUNDAY) {
		    	endDateOfTheWeek = endDateOfTheWeek.plusDays(1);
		    }
			return Date.from(endDateOfTheWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Date getFirstDateOfMonth(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		String dateInString = dt.toString();

		try {
			Date d = sdf.parse(dateInString);
			LocalDate date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate startDateOfTheMonth = date.withDayOfMonth(1);
			return Date.from(startDateOfTheMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Date getLastDateOfMonth(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		String dateInString = dt.toString();
		try {
			Date d = sdf.parse(dateInString);
			LocalDate date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Calendar cal = Calendar.getInstance();
		    int res = cal.getActualMaximum(Calendar.DATE);
		    LocalDate endDateOfTheMonth = date.withDayOfMonth(res);
			return Date.from(endDateOfTheMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
}
