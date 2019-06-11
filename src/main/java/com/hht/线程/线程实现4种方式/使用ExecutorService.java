package com.hht.线程.线程实现4种方式;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class 使用ExecutorService {
	
	
	public static void main(String[] args) throws Exception {
		
		List<Future<String>> list = new ArrayList<Future<String>>();
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		for(int i=1;i<5;i++) {
			Future<String> future = pool.submit(new MyThread(i));
			list.add(future);
		}
		
		pool.shutdown();
		
		for(Future<String> f : list) {
			System.out.println(f.get());
		}
		
	}
	
	
	
	
	

}

