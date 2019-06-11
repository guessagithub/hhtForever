package com.hht.面试题;

public class 目录 {

	public static void main(String[] args) {

		// 1. 有N级楼梯，小孩每次可以选择走1、2、3阶，走完楼梯有多少种可能。
		no_1();
		
	}
	
	private static void no_1() {
		int n = 5;
		Louti louti = new Louti();
		System.out.println(louti.exe(n));
		System.out.println(Louti2.exe(n));
	}

}
