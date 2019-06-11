package com.hht.设计模式.单例模式;

/**
 * 	核心，只要一个私有的构造函数， 最简单的使用方式，但线程不安全
 *
 */
public class Singleton1 {
	
	private static Singleton1 instance = null;
	
	private Singleton1(){};
	
	public static Singleton1 getInstance() {
		if(instance==null) {
			instance = new Singleton1();
		}
		return instance;
	}

}
