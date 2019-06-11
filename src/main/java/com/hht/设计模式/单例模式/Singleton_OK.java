package com.hht.设计模式.单例模式;

/**
 * 	使用内部静态类， 线程安全而且还是延迟加载的
 *
 */
public class Singleton_OK {
	
	private Singleton_OK() {}
	
	// 内部类
	private static class SingletonHolder {
		private static final Singleton_OK instance = new Singleton_OK();
	}
	
	public static Singleton_OK getInstance() {
		return SingletonHolder.instance;
	}

}
