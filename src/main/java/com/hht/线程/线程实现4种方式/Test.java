package com.hht.线程.线程实现4种方式;

import java.util.concurrent.FutureTask;

public abstract class Test {

	public static void main(String[] args) throws Exception {
		
		继承Thread类 type1 = new 继承Thread类();
		type1.start();
		
		
		实现Runnable接口 type2Target = new 实现Runnable接口();
		Thread type2 = new Thread(type2Target);
		type2.start();
		
		// 执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果
		实现Callable接口 type3 = new 实现Callable接口();
		FutureTask<String> futureTask = new FutureTask<String>(type3);
		new Thread(futureTask).start();
		String result = futureTask.get();
		System.out.println(result);
		
		
	}

}
