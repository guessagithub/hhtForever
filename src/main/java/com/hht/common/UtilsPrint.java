package com.hht.common;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class UtilsPrint {
	
	
	public static <T> void printList(List<T> list) {
		System.out.println("-----------------------------------------------------------------");
		for(T value : list){
			System.out.println(value);
		}
	}

	public static <T> void printListInverted(List<T> list){
		System.out.println("-----------------------------------------------------------------");
		ListIterator<T> listIterator = list.listIterator(list.size());
		while(listIterator.hasPrevious()){
			System.out.println(listIterator.previous());
		}
	}


	public static <T> void printArray(T[] values){
		System.out.println("-----------------------------------------------------------------");
		for(T value : values){
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
