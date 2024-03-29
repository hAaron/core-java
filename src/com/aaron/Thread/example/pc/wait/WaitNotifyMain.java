package com.aaron.Thread.example.pc.wait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Aaron
 * @date 2017年6月18日
 * @version 1.0
 * @package_name com.aaron.Thread.example.pc.wait
 */
public class WaitNotifyMain {

    public static void main(String[] args) {
        List<DataCollection> queue = new ArrayList<DataCollection>();
        int length = 10;
        Producer p1 = new Producer(queue, length);
        Producer p2 = new Producer(queue, length);
        Producer p3 = new Producer(queue, length);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(p1);
        service.execute(p2);
        service.execute(p3);
        service.execute(c1);
        service.execute(c2);
        service.execute(c3);

    }

}
