package com.aaron.Thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
 * 
 * @author Aaron
 * @date 2017年6月15日
 * @version 1.0
 * @package_name com.aaron.Thread.pool
 */
class newScheduledThreadPoolThread extends Thread {
	private String name;

	newScheduledThreadPoolThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " 正在执行...");
	}
}

public class TestNewScheduledThreadPool {
	public static void main(String[] args) {
		// 创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
		// 创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
		// 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
		newScheduledThreadPoolThread t1 = new newScheduledThreadPoolThread("A");
		newScheduledThreadPoolThread t2 = new newScheduledThreadPoolThread("B");
		newScheduledThreadPoolThread t3 = new newScheduledThreadPoolThread("C");
		newScheduledThreadPoolThread t4 = new newScheduledThreadPoolThread("E");
		newScheduledThreadPoolThread t5 = new newScheduledThreadPoolThread("D");
		// 将线程放入池中进行执行
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		// 使用延迟执行风格的方法
		pool.schedule(t4, 10, TimeUnit.MILLISECONDS);
		pool.schedule(t5, 10, TimeUnit.MILLISECONDS);
		// 关闭线程池
		pool.shutdown();
	}
}
