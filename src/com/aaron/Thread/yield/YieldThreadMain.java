package com.aaron.Thread.yield;

/**
 * yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。因此，使用yield()
 * 的目的是让相同优先级的线程之间能适当的轮转执行。但是，实际中无法保证yield()达到让步目的，
 * 因为让步的线程还有可能被线程调度程序再次选中。
 * 
 * @author Aaron
 * @date 2017年6月14日
 * @version 1.0
 * @package_name com.aaron.Thread.yield
 */
class YieldThread extends Thread {
	private String name;

	public YieldThread(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.println("" + this.getName() + "-----" + i);
			// 当i为300时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
			if (i == 300) {
				System.out
						.println("当i为300时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）"
								+ this.getName());
				Thread.yield();
			}
		}
	}
}

public class YieldThreadMain {

	public static void main(String[] args) {
		YieldThread yieldThread1 = new YieldThread("A");
		YieldThread yieldThread2 = new YieldThread("B");
		yieldThread1.start();
		yieldThread2.start();

	}

}
