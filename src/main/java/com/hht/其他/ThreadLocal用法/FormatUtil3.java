package com.hht.其他.ThreadLocal用法;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 	这种方式在多线程种没问题，性能也比synchronized高，synchronized是变为方法独享。
 * 
 * 	使用ThreadLocal, 也是将共享变量变为独享，线程独享肯定能比方法独享在并发环境中能减少不少创建对象的开销。
 * 	如果对性能要求比较高的情况下，一般推荐使用这种方法。
 *
 */
public class FormatUtil3 {
	
	private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		}
	};
	
	public static String toString(Date date) {
		return threadLocal.get().format(date);
	}

	public static Date toDate(String str) throws ParseException {
		return threadLocal.get().parse(str);
	}
	
}
