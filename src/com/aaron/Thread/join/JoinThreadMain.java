package com.aaron.Thread.join;

/**
 * join是Thread类的一个方法，启动线程后直接调用，即join()的作用是：“等待该线程终止”，
 * 这里需要理解的就是该线程是指的主线程等待子线程的终止。 也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。
 * 
 * @author Aaron
 * @date 2017年6月14日
 * @version 1.0
 * @package_name com.aaron.Thread.join
 */
class JoinThread extends Thread {
	private String name;

	public JoinThread(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
		for (int i = 0; i < 500; i++) {
			System.out.println("子线程" + name + "运行 : " + i);
			try {
				sleep((int) Math.random() * 10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
	}

}

public class JoinThreadMain {

	public static void main(String[] args) {
		//不加join
//		System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
//		JoinThread join1 = new JoinThread("A");
//		JoinThread join2 = new JoinThread("B");
//		join1.start();
//		join2.start();
//		System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
		
		//加入join
		System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
		JoinThread joinThread1 = new JoinThread("A");
		JoinThread joinThread2 = new JoinThread("B");
		joinThread1.start();
		joinThread2.start();
		try {
			joinThread1.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			joinThread2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
	}

}
