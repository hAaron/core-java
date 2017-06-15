package com.aaron.Thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可变尺寸的线程池 
 * 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，
 * 此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
 * 
 * @author Aaron
 * @date 2017年6月15日
 * @version 1.0
 * @package_name com.aaron.Thread.pool
 */
class newCachedThreadPoolThread extends Thread {
	private String name;

	newCachedThreadPoolThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " 正在执行...");
	}
}

public class TestNewCachedThreadPool {

	public static void main(String[] args) {
		// 创建一个具有缓存功能的线程池，系统根据需要创建线程，这些线程将会被缓存在线程池中。
		ExecutorService executorService = Executors.newCachedThreadPool();
		newCachedThreadPoolThread thread1 = new newCachedThreadPoolThread("线程1");
		newCachedThreadPoolThread thread2 = new newCachedThreadPoolThread("线程2");
		newCachedThreadPoolThread thread3 = new newCachedThreadPoolThread("线程3");
		newCachedThreadPoolThread thread4 = new newCachedThreadPoolThread("线程4");
		newCachedThreadPoolThread thread5 = new newCachedThreadPoolThread("线程5");
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
