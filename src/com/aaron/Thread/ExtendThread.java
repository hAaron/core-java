package com.aaron.Thread;

/**
 * 创建线程方式1：继承Thread 类
 * 
 * @author Aaron
 * @date 2017年5月22日
 * @version 1.0
 * @package_name com.aaron.Thread
 */
public class ExtendThread {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread myThreadA = new MyThread();
        MyThread myThreadB = new MyThread();
        myThread.start();
        myThreadA.start();
        myThreadB.start();
    }

}

class MyThread extends Thread {
    private volatile boolean finshed = false;
    private int ticket = 5;

    public void stopMe() {
        finshed = true;
    }

    public void run() {
        while (!finshed) {
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    Thread.interrupted();
                    stopMe();
                }
                synchronized (MyThreadR.class) {
                    if (ticket > 0) {
                        System.out.println("ticket--" + i + " ===" + ticket--);
                    }
                }
            }
        }
    }
}
