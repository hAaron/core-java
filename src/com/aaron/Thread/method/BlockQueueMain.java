package com.aaron.Thread.method;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BlockQueue
 * 
 * @author Aaron
 * @date 2018年4月21日
 * @version 1.0
 * @package_type com.aaron.Thread.method.BlockQueueMain
 */
// ArrayBlockingQueue ：一个由数组结构组成的有界阻塞队列。
// LinkedBlockingQueue ：一个由链表结构组成的有界阻塞队列。
// PriorityBlockingQueue ：一个支持优先级排序的无界阻塞队列。
// DelayQueue：一个使用优先级队列实现的无界阻塞队列。
// SynchronousQueue：一个不存储元素的阻塞队列。
// LinkedTransferQueue：一个由链表结构组成的无界阻塞队列。
// LinkedBlockingDeque：一个由链表结构组成的双向阻塞队列。
public class BlockQueueMain {

	/**
	 * 定义一个容器
	 * 
	 * @author Aaron
	 * @date 2018年4月21日
	 * @version 1.0
	 * @package_type com.aaron.Thread.method.cotion
	 */
	static class Container {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

		public void produce() {
			try {
				// java.lang.IllegalStateException: Queue full
				// ArrayBlockingQueue 定长的queue用add放入抛出的异常
				// 推荐使用put
				queue.put("add..");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public String consume() {
			try {
				return queue.poll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	/**
	 * 生产消费
	 */
	public static void operate() {

		final Container container = new Container();

		class Producer implements Runnable {

			@Override
			public void run() {
				while (true) {
					System.out.print("开始produce。。。。。");
					container.produce();
					System.out.println("结束produce。。。。。");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}

		class Consumer implements Runnable {

			@Override
			public void run() {
				while (true) {
					System.out.print("开始consume。。。。。");
					container.consume();
					System.out.println("结束consume。。。。。");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}

		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(new Producer());
		executor.submit(new Producer());
		executor.submit(new Consumer());
		executor.shutdown();

	}

	public static void main(String[] args) {
		BlockQueueMain.operate();
	}

}
