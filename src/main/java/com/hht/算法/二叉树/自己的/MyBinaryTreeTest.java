package com.hht.算法.二叉树.自己的;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyBinaryTreeTest {

	public static void main(String[] args) {
		
		test2();
		
	}
	
	private static void test2() {
		List<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i=0;i<40;i++) {
			list.add(rand.nextInt(500));
		}
		
		MyBinaryTree<Integer> tree = new MyBinaryTree<Integer>();
		tree.insert(list);

		print(tree);
	}
	
	public static void test1() {
		
		MyBinaryTree<String> tree = new MyBinaryTree<String>();
		
		List<String> list = new ArrayList<String>();
		
//		list.add("E");
//		list.add("D");
//		list.add("G");
//		list.add("A");
//		list.add("F");
//		list.add("C");
//		list.add("B");
//		list.add("H");

		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");

		tree.insert(list);
		
		print(tree);
		
	}
	
	@SuppressWarnings("rawtypes")
	private static void print(MyBinaryTree tree) {

		System.out.print("前序 ： ");
		tree.prePrint();
		System.out.println();

		System.out.print("中序 ： ");
		tree.inPrint();
		System.out.println();

		System.out.print("后序 ： ");
		tree.postPrint();
		System.out.println();

		System.out.println(String.format("最小值 ： %s ", tree.getMixValue()));
		System.out.println(String.format("最大值 ： %s ", tree.getMaxValue()));
		}

}
