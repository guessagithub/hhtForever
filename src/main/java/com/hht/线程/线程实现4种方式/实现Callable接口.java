package com.hht.线程.线程实现4种方式;

import java.util.concurrent.Callable;

public class 实现Callable接口 implements Callable<String>{

	public String call() throws Exception {
		return "实现Callable接口，实现多线程！";
	}

}
