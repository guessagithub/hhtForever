package com.hht.线程.线程实现4种方式;

import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
	
	private int id;
	public MyThread(int id) {
		this.id = id;
	}
	public String call() throws Exception {
		return "使用ExecutorService，实现多线程！  id=" + id;
	}
	
	
}
