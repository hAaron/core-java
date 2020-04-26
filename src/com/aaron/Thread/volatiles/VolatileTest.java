package com.aaron.Thread.volatiles;

/**
 * volatile关键字
 * 
 * @author Aaron
 * @date 2019年11月25日
 * @version 1.0
 * @package_type com.aaron.Thread.volatiles.VolatileTest
 */
public class VolatileTest {
	private static class VolatileVar implements Runnable {
		private volatile Boolean flag = true; // 有volatile和没volatile效果明显

		@Override
		public void run() {
			while (true) {
				if (flag) {
					System.out.println(Thread.currentThread().getName() + ":>>>>>" + flag);
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileVar v = new VolatileVar();
		Thread t1 = new Thread(v);
		Thread t2 = new Thread(v);
		Thread t3 = new Thread(v);
		Thread t4 = new Thread(v);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		Thread.sleep(500);
		v.flag = false;
		System.out.println("I sleep 3s");
		Thread.sleep(3000);
		System.out.println("I will start now");
		v.flag = true;
	}

}