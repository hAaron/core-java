package com.aaron.Thread.example.pc.wait;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 * 
 * @author Aaron
 * @date 2017年6月18日
 * @version 1.0
 * @package_name com.aaron.Thread.example.pc.wait
 */
public class Consumer implements Runnable {
	private List<DataCollection> queue;

	public Consumer(List<DataCollection> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				if (Thread.currentThread().isInterrupted()) {
					break;
				}
				DataCollection dataCollection = null;
				synchronized (queue) {
					if (queue.size() == 0) {
						queue.wait();
						queue.notifyAll();
					}
					dataCollection = queue.remove(0);
				}
				System.out.println("消费者[" + Thread.currentThread().getId()
						+ "] 消费了:" + dataCollection.get() + " result:"
						+ (dataCollection.get() * dataCollection.get()));
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
