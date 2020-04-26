package com.aaron.Thread.stopthread.interrupt;

/**
 * 方法二：使用Thread中断机制interrupt(中断一个线程，)
 * 
 * @author Aaron
 * @date 2019年11月19日
 * @version 1.0
 * @package_type com.aaron.Thread.stopthread.interrupt.StopThreadMain2
 */
public class StopThreadMain2 {
	// public void interrupt()
	// public boolean isInterrupted() //判断是否被中断
	// public static boolean interrupted(); // 清除中断标志，并返回原状态

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread);
		thread.start();
		try {
			Thread.sleep(3000);
			thread.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class MyThread implements Runnable {

	public void run() {

		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("thread status:" + Thread.currentThread().isInterrupted());
			try {
				System.out.println("running do something");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("InterruptedException");
				System.out.println("thread status:" + Thread.currentThread().isInterrupted());
				// 重新设置中断标示
				Thread.currentThread().interrupt();
				System.out.println("thread status:" + Thread.currentThread().isInterrupted());
			}
		}
		System.out.println("Thread stop");
	}

}
