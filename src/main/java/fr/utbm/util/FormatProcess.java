package fr.utbm.util;

import java.util.Calendar;
import java.util.Date;

public class FormatProcess {

	public static String concactQuery(String s) {
		return "%" + s + "%";
	}

	public static String toPgDate(String s) {
		String[] dateStr = s.split("/");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, new Integer(dateStr[2].trim()));
		calendar.set(Calendar.MONTH, new Integer(dateStr[1].trim()));
		calendar.set(Calendar.DATE, new Integer(dateStr[0].trim()));
		Date date = calendar.getTime();
		
		switch (dateStr.length) {
		case 1:
			return dateStr[0];
		case 2:
			return dateStr[0]+"-"+dateStr[1];
		case 3:
			return dateStr[0]+"/"+dateStr[1]+"/"+dateStr[2];
		default:
			return ""; 
		}
	
			
		
	}
}
