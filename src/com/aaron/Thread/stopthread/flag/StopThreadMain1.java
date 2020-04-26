package com.aaron.Thread.stopthread.flag;

/**
 * 方法一：使用volatile关键字设置标志位(running do something阻塞时，后面检查不了isCancelled的状态)
 * 
 * @author Aaron
 * @date 2019年11月19日
 * @version 1.0
 * @package_type com.aaron.Thread.stopthread.StopThreadMain
 */
public class StopThreadMain1 {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread);
		thread.start();
		try {
			Thread.sleep(1000);
			myThread.cancel();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class MyThread implements Runnable {

	private volatile boolean isCancelled = false;

	public void run() {
		while (!isCancelled) {
			System.out.println("running do something");
		}
	}

	public void cancel() {
		isCancelled = true;
		System.out.println("thread cancel");
	}

}
