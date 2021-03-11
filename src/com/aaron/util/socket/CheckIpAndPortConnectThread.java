package com.aaron.util.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 检测ip:port 是否正常连接 （多线程处理在测试连接时候超时阻塞问题）
 * 
 * @author Aaron
 * @date 2018年2月28日
 * @version 1.0
 * @package_type com.aaron.util.socket.CheckIpAndPortConnectThread
 */
public class CheckIpAndPortConnectThread {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);

        Callable<String> c1 = new CheckHeart("192.168.128.129", 9100);
        Callable<String> c2 = new CheckHeart("192.168.128.129", 9200);
        Callable<String> c3 = new CheckHeart("192.168.128.129", 9300);

        // 表示异步计算的结果
        Future<String> f1 = pool.submit(c1);
        Future<String> f2 = pool.submit(c2);
        Future<String> f3 = pool.submit(c3);

        // 这里要等线程1运行完,f1.get()得到值后,才会走System.out.println(f2.get());
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();
        list.add(f1.get());
        list.add(f2.get());
        list.add(f3.get());
        System.out.println(list);
        for (String string : list) {
            if (string != null) {
                result.add(string);
            }
        }
        System.out.println(result);
        // 关闭线程池
        pool.shutdown();
    }

    public static boolean isEmpty(String string) {
        if (string == null || "null".equals(string) || "".equals(string) || " ".equals(string)) {
            return true;
        }
        return false;
    }

}

class CheckHeart implements Callable<String> {
    private String host;
    private int port;

    public CheckHeart() {}

    public CheckHeart(String host, int port) {
        super();
        this.host = host;
        this.port = port;
    }

    public static boolean isHostConnectable(String host, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public String call() throws Exception {
        System.out.println(host + ":" + port + ">>>>>");
        boolean result = isHostConnectable(host, port);
        if (result == true) {
            return host + ":" + port;
        }
        return null;
    }
}
