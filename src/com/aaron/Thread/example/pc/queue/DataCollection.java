package com.aaron.Thread.example.pc.queue;

/**
 * 容器数据类型
 * 
 * @author Aaron
 * @date 2017年6月18日
 * @version 1.0
 * @package_name com.aaron.Thread.example.pc.queue
 */
public class DataCollection {
    private final int intData;

    public DataCollection(int d) {
        intData = d;
    }

    public DataCollection(String d) {
        intData = Integer.valueOf(d);
    }

    public int getData() {
        return intData;
    }

    @Override
    public String toString() {
        return "data:" + intData;
    }
}
