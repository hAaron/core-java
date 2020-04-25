package com.aaron.Thread.example.pc.awaits;

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
 * @package_name com.aaron.Thread.example.pc.awaits
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
				if (Thread.currentThread().isInterrupted())
					break;
				DataCollection data = null;
				AwaitSignalMain.lock.lock();
				if (queue.size() == 0) {
					AwaitSignalMain.full.signalAll();
					AwaitSignalMain.empty.await();
				}
				Thread.sleep(1000);
				data = queue.remove(0);
				AwaitSignalMain.lock.unlock();
				System.out.println("消费者ID:" + Thread.currentThread().getId()
						+ " 消费了:" + data.getData() + " result:"
						+ (data.getData() * data.getData()));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
