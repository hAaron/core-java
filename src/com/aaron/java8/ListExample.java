package com.aaron.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author huangbo
 * @date 2021/4/29
 */
public class ListExample {
    public static List<Apple> appleList = new ArrayList<>();// 存放apple对象集合

    public static Gson logGson = new GsonBuilder().create();

    static {
        initList();
    }

    public static void main(String[] args) {

        /**
         * List -> Map 需要注意的是： toMap 如果集合对象有重复的key，会报错Duplicate key .... apple1,apple12的id都为1。 可以用 (k1,k2)->k1
         * 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Integer, Apple> appleMap =
            appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a, (k1, k2) -> k1));
        System.out.println(logGson.toJson(appleMap));

        // List 以ID分组 Map<Integer,List<Apple>>
        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println(logGson.toJson(groupBy));
        // 多层分组
        Map<Integer, Map<String, List<Apple>>> infoMap =
            appleList.stream().collect(Collectors.groupingBy(Apple::getId, Collectors.groupingBy(Apple::getName)));
        System.out.println(logGson.toJson(infoMap));

        // 过滤出符合条件的数据
        List<Apple> filterList = appleList.stream().filter(a -> a.getName().equals("香蕉")).collect(Collectors.toList());
        System.out.println(logGson.toJson(filterList));
    }

    public static void initList() {
        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
        Apple apple12 = new Apple(1, "苹果2", new BigDecimal("1.35"), 20);
        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("2.89"), 30);
        Apple apple3 = new Apple(3, "荔枝", new BigDecimal("9.99"), 40);

        // appleList.add(apple1);
        // appleList.add(apple12);
        // appleList.add(apple2);
        // appleList.add(apple3);
    }

}

class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;

    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}