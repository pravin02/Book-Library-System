package org.pk.booklibrary.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Utility class for handling date-time.
 * 
 * @author PKCORP
 * @since 26/04/2017
 */
public class DateTimeUtils {
	public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
	public static final String FILE_NAME_FORMAT = "dd_MM_yyyy_HH_mm_ss";

	/**
	 * Method to get the current date-time in the input format.
	 * 
	 * @param dateTimeFormat
	 *            the date-time format
	 * @param timestamp
	 *            the timestamp to be formatted
	 * @return the current date-time in the input format
	 */
	public static String getFormattedTime(String dateTimeFormat, long timestamp) {
		Date date = new Date(timestamp);
		SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormat, Locale.US);
		return sdf.format(date);
	}

	/**
	 * Method to get the current date-time in the input format.
	 * 
	 * @param dateTimeFormat
	 *            the date-time format
	 * @return the current date-time in the input format
	 */
	public static String getFormattedTime(String dateTimeFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormat, Locale.US);
		Date date = new Date(System.currentTimeMillis());
		return sdf.format(date);
	}

	/**
	 * @return current date time
	 */
	public static String getCurrentDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
		return sdf.format(new Date());
	}

	/**
	 * @return current date time for file name
	 */
	public static String getCurrentDateTimeForFile() {
		SimpleDateFormat sdf = new SimpleDateFormat(FILE_NAME_FORMAT);
		return sdf.format(new Date());
	}
}