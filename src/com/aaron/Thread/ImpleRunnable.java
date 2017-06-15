package com.aaron.Thread;

/**
 * 创建线程方式2：实现Runnable接口
 * 
 * @author Aaron
 * @date 2017年5月22日
 * @version 1.0
 * @package_name com.aaron.Thread
 */
public class ImpleRunnable {
	public static void main(String[] args) {

		MyThreadR myThreadR = new MyThreadR();
		Thread thread = new Thread(myThreadR);
		Thread threadA = new Thread(myThreadR);
		Thread threadB = new Thread(myThreadR);
		thread.start();
		threadA.start();
		threadB.start();

	}
}

class MyThreadR implements Runnable {
	private int ticket = 100;

	@Override
	public void run() {
		while (true) {
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName()
						+ "正在售票---票号为：" + ticket--);
			}
		}

	}

}
