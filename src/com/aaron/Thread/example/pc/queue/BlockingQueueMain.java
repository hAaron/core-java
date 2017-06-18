package com.aaron.Thread.example.pc.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * BlockingQueue是一个阻塞队列，它的存取可以保证只有一个线程在进行， 
 * 所以根据逻辑，生产者在内存满的时候进行等待，并且唤醒消费者队列，
 * 反过来消费者在饥饿状态下等待并唤醒生产者进行生产。
 * 
 * @author Aaron
 * @date 2017年6月18日
 * @version 1.0
 * @package_name com.aaron.Thread.example.pc.queue
 */
public class BlockingQueueMain {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<DataCollection> queue = new LinkedBlockingDeque<>(10);
		Producer p1 = new Producer(queue);
		Producer p2 = new Producer(queue);
		Producer p3 = new Producer(queue);
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(p1);
		service.execute(p2);
		service.execute(p3);
		service.execute(c1);
		service.execute(c2);
		service.execute(c3);
		Thread.sleep(10 * 1000);
		p1.stop();
		p2.stop();
		p3.stop();
		Thread.sleep(3000);
		service.shutdown();
	}
}
