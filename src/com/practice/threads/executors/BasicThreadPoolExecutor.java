package com.practice.threads.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class BasicThreadPoolExecutor {
	
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		for(int i = 0; i <= 5; i++) {
			Task task = new Task("Task" + i);
			System.out.println("A new task has been added: " + task.getName());
			executor.execute(task);
		}
		System.out.println("Executor thread count: " + executor.getPoolSize());
		executor.shutdown();
	}

}
