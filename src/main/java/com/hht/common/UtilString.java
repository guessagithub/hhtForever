package com.hht.common;

public class UtilString {

	public static boolean isEmpty(String value) {
		return value!=null&&value.trim().length()>0?false:true;
	}
	
	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}
	
	
	public static void main(String[] args) {
		System.out.println(isNotEmpty(" d  "));
	}

}
