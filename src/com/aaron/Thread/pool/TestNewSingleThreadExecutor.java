package com.aaron.Thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单任务线程池 
 * 创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。
 * 如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它 。
 * 此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
 * 
 * 
 * @author Aaron
 * @date 2017年6月15日
 * @version 1.0
 * @package_name com.aaron.Thread.pool
 */
class newSingleThreadExecutorThread extends Thread {
	private String name;

	newSingleThreadExecutorThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " 正在执行...");
	}
}

public class TestNewSingleThreadExecutor {

	public static void main(String[] args) {
		// 创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
		// 它相当于newFixedThreadPool方法传递参数1
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		newSingleThreadExecutorThread thread1 = new newSingleThreadExecutorThread(
				"线程1");
		newSingleThreadExecutorThread thread2 = new newSingleThreadExecutorThread(
				"线程2");
		newSingleThreadExecutorThread thread3 = new newSingleThreadExecutorThread(
				"线程3");
		newSingleThreadExecutorThread thread4 = new newSingleThreadExecutorThread(
				"线程4");
		newSingleThreadExecutorThread thread5 = new newSingleThreadExecutorThread(
				"线程5");
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
