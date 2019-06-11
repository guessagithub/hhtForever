package com.hht.线程.线程池concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 	创建一个定长线程池，支持定时及周期性任务执行。
 *	表示延迟10秒后每3秒执行一次。
 */
public class newScheduledThreadPool {

	public static void main(String[] args) {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		
		// scheduleAtFixedRate 不管有没有执行完，每隔一定频率必须执行一次
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("delay 10 seconds, and excute every 3 seconds");
			}
		}, 10, 3, TimeUnit.SECONDS);
		
		// scheduleWithFixedDelay 上次执行完以后，再延迟指定时间执行
		scheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
			public void run() {
				System.out.println("delay 10 seconds, and excute delay 5 seconds");
			}
		}, 10, 5, TimeUnit.SECONDS);
		
	}

}
