package com.huolili.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public  String getCurrentTime(){
		Date date=new Date();
		  SimpleDateFormat Format=new SimpleDateFormat("yyyyMMdd-HH:mm:ss");
		  String time=Format.format(date);
		  return time;

	}
}
