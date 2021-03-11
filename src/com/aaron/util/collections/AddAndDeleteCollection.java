package com.aaron.util.collections;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Java 遍历List ConcurrentModificationException 解决方法(多线程 )
 * 
 * CopyOnWriteArrayList不能使用Iterator.remove()进行删除
 * 
 * @author Aaron
 * @date 2018年4月3日
 * @version 1.0
 * @package_type com.aaron.util.collections.AddAndDeleteCollection
 */
public class AddAndDeleteCollection {
    public static void main(String[] args) {

        final List<String> myList = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < args.length; i++) {
            myList.add("6yhn" + i);

        }

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (String string : myList) {
                    System.out.println("遍历集合 value = " + string);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < myList.size(); i++) {
                    String value = myList.get(i);

                    System.out.println("删除元素 value = " + value);

                    if (value.equals("3")) {
                        myList.remove(value);
                        i--; // 注意
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

class SecondMethod {
    public static List<String> myList = new CopyOnWriteArrayList<String>();

    public static void main1(String[] args) {
        for (int i = 0; i < 5; i++) {
            myList.add("i" + i);

        }
        System.out.println(myList);
        String value = getValue();
        System.out.println(value);
        System.out.println(myList);
    }

    private static String getValue() {
        String value = null;
        for (int i = 0; i < myList.size();) {
            value = myList.get(i);
            myList.remove(myList.get(i));
            break;
        }
        return value;
    }
}
