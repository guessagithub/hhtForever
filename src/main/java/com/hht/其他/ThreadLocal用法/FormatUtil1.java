package com.hht.其他.ThreadLocal用法;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 这种方式在多线程种是会出问题的
 *
 */
public class FormatUtil1 {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
	public static String toString(Date date) {
		return sdf.format(date);
	}

	public static Date toDate(String str) throws ParseException {
		return sdf.parse(str);
	}
}
