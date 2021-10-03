/**
 * 
 */
package com.oneocean.utilities;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Vikram Viswanathan
 * @date October 03, 2021
 *
 */
public class CommonUtilities {
	private static final Logger logger = LogManager.getLogger(CommonUtilities.class);
	
	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public static double calculateDistance(int x1, int y1, int x2, int y2) {
		return Math.round(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) * 1.0) * 100.0) / 100.0;
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static double caculateTravelTime(String start, String end) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		double timeDifference = 0.0;
		
		try {
			ZonedDateTime startDateTime = ZonedDateTime.parse(start, formatter);
			ZonedDateTime endDateTime = ZonedDateTime.parse(end, formatter);
			
			timeDifference = Duration.between(startDateTime, endDateTime).getSeconds();
		} catch(Exception e) {
			logger.error("Unable to parse datetime -> " + e.getMessage());
		}
		
		return timeDifference;
	}
	
	/**
	 * 
	 * @param distance
	 * @param time
	 * @return
	 */
	public static double calculateSpeed(double distanceInKms, double timeInHours) {
		return Math.round((distanceInKms / timeInHours) * 100.00) / 100.00;
	}
}