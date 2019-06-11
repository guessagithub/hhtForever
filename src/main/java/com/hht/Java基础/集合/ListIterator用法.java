package com.hht.Java基础.集合;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.hht.common.UtilsPrint;

public class ListIterator用法 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		UtilsPrint.printList(list);
		
		// 测试add方法
		add(list, "a", "aa");
		
		// 测试remove方法
		remove(list, "c");
		
		// 测试逆序遍历
		UtilsPrint.printListInverted(list);
		
	}
	
	/**
	 * 删除等于value的元素
	 * @param list
	 * @param value
	 */
	private static void remove(List<String> list, String value){
		ListIterator<String> listIterator = list.listIterator();
		while(listIterator.hasNext()){
			if(listIterator.next().equals(value)){
				listIterator.remove();
			}
		}
		UtilsPrint.printList(list);
	}
	
	/**
	 * 在valueIndex的后面插入valueNew
	 * @param list
	 * @param valueIndex
	 * @param valueNew
	 */
	private static void add(List<String> list, String valueIndex, String valueNew){
		ListIterator<String> listIterator = list.listIterator();
		while(listIterator.hasNext()){
			String value = listIterator.next();
			if(valueIndex.equals(value)){
				listIterator.add(valueNew);
			}
		}
		
		UtilsPrint.printList(list);		
	}
	

}
