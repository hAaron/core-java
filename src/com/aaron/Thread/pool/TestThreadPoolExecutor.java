package com.aaron.Thread.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor:自定义线程池
 * 
 * @author Aaron
 * @date 2018年8月1日
 * @version 1.0
 * @package_type com.aaron.Thread.pool.TestThreadPoolExecutor
 */
public class TestThreadPoolExecutor {

	public static void main(String[] args) {
		// ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
		// TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler
		// handler)

		// BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(2);
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		// BlockingQueue<Runnable> queue = new PriorityBlockingQueue<Runnable>();
		// BlockingQueue<Runnable> queue = new SynchronousQueue<Runnable>();

		// AbortPolicy/CallerRunsPolicy/DiscardOldestPolicy/DiscardPolicy
		// 如果workQueue使用LinkedBlockingQueue队列，因为它是无界的，队列永远不会满，所以maximumPoolSize参数是没有意义的，同样keepAliveTime、unit、handler三个参数都无意义。
		// 如果workQueue使用ArrayBlockingQueue队列，那么小心，因为此队列是有界的，必须小心处理拒绝策略
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS, queue,
				new ThreadPoolExecutor.AbortPolicy());

		// ExecutorService exec = Executors.newCachedThreadPool();

		// 向线程池里面扔任务
		for (int i = 0; i < 10; i++) {
			System.out.println("当前线程池大小[" + threadPool.getPoolSize() + "],当前队列大小[" + queue.size() + "]");

			threadPool.execute(new MyThread("Thread" + i));
		}
		// 关闭线程池
		threadPool.shutdown();
	}
}

class MyThread implements Runnable {
	String name;

	public MyThread() {
	}

	MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("ThreadPoolExecutor测试:" + name);
	}
}