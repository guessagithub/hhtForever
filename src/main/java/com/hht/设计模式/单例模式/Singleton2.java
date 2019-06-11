package com.hht.设计模式.单例模式;

/**
 * 	线程安全的， 但instance在类装载时就实例化，显然没有达到lazy loading的效果。
 *
 */
public class Singleton2 {
	
	private static Singleton2 instance = new Singleton2();
	
	private Singleton2(){}
	
	public static Singleton2 getInstance() {
		return instance;
	}

}
