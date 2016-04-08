package com.practice.threads.executors;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorExample {

	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		Task task1 = new Task("Demo Task 1");
		Task task2 = new Task("Demo Task 2");
		System.out.println("The time is: " + new Date());
		
		executor.schedule(task1, 5, TimeUnit.SECONDS);
		executor.schedule(task2, 10, TimeUnit.SECONDS);
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		executor = Executors.newScheduledThreadPool(1);
		System.out.println("the time is: " + new Date());
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task1, 2, 5, TimeUnit.SECONDS);
		try {
			TimeUnit.MILLISECONDS.sleep(20000);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		executor.shutdown();
	}

}
