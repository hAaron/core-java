package com.aaron.Thread.example.soldticket;

/**
 * 售票员卖票问题 　
 * synchronized原理是，执行synchronized部分代码的时候必须需要对象锁，而一个对象只有一个锁，
 * 只有执行完synchronized里面的代码后释放锁
 * ，其他线程才可以获得锁，那么就保证了同一时刻只有一个线程访问synchronized里面的代码。使得资源共享的关键是
 * ，只有一个实例，synchronized使用的是同一把锁
 * ，用实例的锁或者定义一个实例。这就需要使用实现Runnable接口的方式，实现多线程，这样传入的是一个实例
 * 。继承Thread的方式，传入的是多个实例，每个实例都有一个锁，那就无法实现控制。
 * 
 * @author Aaron
 * @date 2017年6月14日
 * @version 1.0
 * @package_name com.aaron.Thread.example
 */
class Ticket implements Runnable {

	private int num = 100;
	Object object = new Object();

	public void sale() {
		synchronized (object) {
			if (num > 0) {
				System.out.println("当前售票员：" + Thread.currentThread().getName()
						+ " 正在卖票，票号为N-" + num + "--还剩下" + (num - 1) + "张票");
				num--;
			} else {
				System.out.println("票已经卖光。。。。");
			}

		}
	}

	@Override
	public void run() {
		while (num > 0) {
			sale();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}

public class TicketClient {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		Thread thread1 = new Thread(ticket, "A10001");
		Thread thread2 = new Thread(ticket, "A10002");
		Thread thread3 = new Thread(ticket, "A10003");
		Thread thread4 = new Thread(ticket, "A10004");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
