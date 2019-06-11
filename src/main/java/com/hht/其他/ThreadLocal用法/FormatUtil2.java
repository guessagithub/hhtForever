package com.hht.其他.ThreadLocal用法;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 这种方式在多线程种没问题，但是会影响性能
 * 当一个线程调用该方法时，其他想要调用此方法的线程就要block，多线程并发量大的时候会对性能有一定的影响。
 *
 */
public class FormatUtil2 {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
	public static String toString(Date date) {
		synchronized(sdf) {
			return sdf.format(date);
		}
	}

	public static Date toDate(String str) throws ParseException {
		synchronized(sdf) {
			return sdf.parse(str);
		}
	}
}
