package com.aaron.Thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定大小的线程池.
 * 创建固定大小的线程池。每次提交一个任务就创建一个线程， 直到线程达到线程池的最大大小。
 * 线程池的大小一旦达到最大值就会保持不变，
 * 如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
 * 
 * @author Aaron
 * @date 2017年6月15日
 * @version 1.0
 * @package_name com.aaron.Thread.pool
 */
class newFixedThreadPoolThread extends Thread {
	private String name;

	newFixedThreadPoolThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " 正在执行...");
	}
}

public class TestNewFixedThreadPool {

	public static void main(String[] args) {
		// 创建一个可重用的、具有固定线程数的线程池
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		newFixedThreadPoolThread thread1 = new newFixedThreadPoolThread("线程1");
		newFixedThreadPoolThread thread2 = new newFixedThreadPoolThread("线程2");
		newFixedThreadPoolThread thread3 = new newFixedThreadPoolThread("线程3");
		newFixedThreadPoolThread thread4 = new newFixedThreadPoolThread("线程4");
		newFixedThreadPoolThread thread5 = new newFixedThreadPoolThread("线程5");
		// 将线程放入池中进行执行
		executorService.execute(thread1);
		executorService.execute(thread2);
		executorService.execute(thread3);
		executorService.execute(thread4);
		executorService.execute(thread5);
		// 关闭线程池
		executorService.shutdown();
	}

}
