package com.aaron.Thread.example.pc.wait;

import java.util.List;
import java.util.Random;

/**
 * 生产者
 * 
 * @author Aaron
 * @date 2017年6月18日
 * @version 1.0
 * @package_name com.aaron.Thread.example.pc.wait
 */
public class Producer implements Runnable {

    private List<DataCollection> queue;
    private int length;

    public Producer(List<DataCollection> queue, int length) {
        this.queue = queue;
        this.length = length;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                Random random = new Random();
                long temp = random.nextInt(1000);
                System.out.println("生产者[" + Thread.currentThread().getId() + "] 生产了：" + temp);
                DataCollection dataCollection = new DataCollection();
                dataCollection.set(temp);
                synchronized (queue) {
                    if (queue.size() >= length) {
                        queue.notifyAll();
                        queue.wait();
                    } else {
                        queue.add(dataCollection);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
