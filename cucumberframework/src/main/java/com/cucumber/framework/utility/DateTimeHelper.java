package com.cucumber.framework.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * @author hiteshg
 *
 */

public class DateTimeHelper {
	
	public static String getCurrentDateTime()
	{
		DateFormat dateformat= new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
		Calendar cal=Calendar.getInstance();
		String time=""+dateformat.format(cal.getTime());
		System.out.println(time);
		return time;
	}
	
	public static String getCurrentDate()
	{
		return getCurrentDateTime().substring(0,11);
	}
	
	public static void main(String[] args) {
		getCurrentDate();
	}

}
