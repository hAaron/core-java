package com.aaron.Thread.example.pc.awaits;

import java.util.List;
import java.util.Random;

/**
 * 生产者
 * 
 * @author Aaron
 * @date 2017年6月18日
 * @version 1.0
 * @package_name com.aaron.Thread.example.pc.awaits
 */
public class Producer implements Runnable {

    private List<DataCollection> queue;
    private int len;

    public Producer(List<DataCollection> queue, int len) {
        this.queue = queue;
        this.len = len;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted())
                    break;
                Random r = new Random();
                DataCollection data = new DataCollection();
                data.setData(r.nextInt(500));
                AwaitSignalMain.lock.lock();
                if (queue.size() >= len) {
                    AwaitSignalMain.empty.signalAll();
                    AwaitSignalMain.full.await();
                }
                Thread.sleep(1000);
                queue.add(data);
                AwaitSignalMain.lock.unlock();
                System.out.println("生产者ID:" + Thread.currentThread().getId() + " 生产了:" + data.getData());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
