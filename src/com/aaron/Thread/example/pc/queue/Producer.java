package com.aaron.Thread.example.pc.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者
 * 
 * @author Aaron
 * @date 2017年6月18日
 * @version 1.0
 * @package_name com.aaron.Thread.example.pc.queue
 */
public class Producer implements Runnable {

	private volatile boolean isRunning = true;
	private BlockingQueue<DataCollection> queue;// 内存缓冲区
	private static AtomicInteger count = new AtomicInteger();// 总数，院子操作

	private static final int SLEEPTIME = 1000;

	Producer(BlockingQueue<DataCollection> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		DataCollection data = null;
		Random random = new Random();
		System.out.println("start producting id:"
				+ Thread.currentThread().getId());
		try {
			while (isRunning) {
				Thread.sleep(SLEEPTIME);
				data = new DataCollection(count.incrementAndGet());
				System.out.println(data + " 加入队列");
				if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
					System.err.println(" 加入队列失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}

	}

	public void stop() {
		isRunning = false;
	}
}
