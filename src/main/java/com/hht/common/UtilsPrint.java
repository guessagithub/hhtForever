package com.hht.common;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class UtilsPrint {

	public static void printList(List<String> list){
		System.out.println("-----------------------------------------------------------------");
		for(String value : list){
			System.out.println(value);
		}
	}

	public static void printListInverted(List<String> list){
		System.out.println("-----------------------------------------------------------------");
		ListIterator<String> listIterator = list.listIterator(list.size());
		while(listIterator.hasPrevious()){
			System.out.println(listIterator.previous());
		}
	}


	public static void printArray(Object[] values){
		System.out.println("-----------------------------------------------------------------");
		for(Object value : values){
			System.out.println(value);
		}
	}


	public static void printArray(int[] values){
		System.out.println("-----------------------------------------------------------------");
		for(int value : values){
			System.out.println(value);
		}
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		printListInverted(list);
		
	}

}
