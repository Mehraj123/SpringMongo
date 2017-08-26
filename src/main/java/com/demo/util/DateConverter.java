package com.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Mehraj Malik
 *
 */
public class DateConverter {

	/**
	 * @author Mehraj Malik
	 * @param strDate String form of date to be parsed
	 * @return Parsed string 
	 * @throws ParseException if failed to parse the provided string date 
	 * <p> Validate and return the provided strDate if parsed successfully else
	 *    throw {@link ParseException}
	 */
	public static String validateDate(String strDate) throws ParseException{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		try {
			df.parse(strDate);
			return strDate;
		} catch (ParseException e) {
			throw new ParseException("Unparsable date : "+strDate, 1);
		}
	}
	
	/**
	 * @author Mehraj Malik
	 * <p> Validate and return the provided strDateTime if parsed successfully else
	 *    throw {@link ParseException}
	 * @param strDateTime String form of date and time to be parsed
	 * @return Parsed String
	 * @throws ParseException if failed to parse the provided string date 
	 */
	public static String validateDateTime(String strDateTime) throws ParseException{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		df.setLenient(false);
		try {
			df.parse(strDateTime);
			return strDateTime;
		} catch (ParseException e) {
			throw new ParseException("Unparsable date : "+strDateTime, 1);
		}
	}
	
}
