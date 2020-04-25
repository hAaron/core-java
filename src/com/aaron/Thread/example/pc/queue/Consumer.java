package com.aaron.Thread.example.pc.queue;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 * 
 * @author Aaron
 * @date 2017年6月18日
 * @version 1.0
 * @package_name com.aaron.Thread.example.pc.queue
 */
public class Consumer implements Runnable {
	private BlockingQueue<DataCollection> queue;
	private static final int SLEEPTIME = 1000;

	public Consumer(BlockingQueue<DataCollection> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println("start Consumer id :"
				+ Thread.currentThread().getId());
		Random random = new Random();
		try {
			while (true) {
				DataCollection data = queue.take();
				if (data != null) {
					int re = data.getData() * data.getData();
					System.out.println(MessageFormat.format("{0}*{1}={2}",
							data.getData(), data.getData(), re));
					Thread.sleep(random.nextInt(SLEEPTIME));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
