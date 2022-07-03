package com.edureka.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {	
	public DateTime() {
		
	}
	public String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		return formatter.format(date);
	}

	public String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss-SSS");
		Date date = new Date();
		return formatter.format(date);
	}

}
