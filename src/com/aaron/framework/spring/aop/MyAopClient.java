package com.aaron.framework.spring.aop;

import java.util.Arrays;

/**
 * 手动实现cglib 版本 spring aop
 * 
 * 1 扫描 aop 包， 获取 aspect 的类
 * 
 * 2 根据 切点 获取该切点的 类 和 方法
 * 
 * 3 根据配置的 类 和 方法 为该类生成一个代理对象
 * 
 * 4 将改代理对象放入 bean Map 中
 * 
 * 5 调用的时候 将代理对象 转换成需要的对象
 * 
 * @author Aaron
 * @date 2018年8月3日
 * @version 1.0
 * @package_type com.aaron.spring.aop.MyAopClient
 */
public class MyAopClient {
    public static void main(String[] args) {
        // 模拟容器初始化
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        // 生成的代理对象 默认为该类名的小写
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.deleteUserById("1234");
        userService.findUserById("1234");
        userService.deleteAll();
        System.out.println("\n=====分========割========线=====\n");

        OrderService orderService = (OrderService)applicationContext.getBean("orderService");
        orderService.deleteOrderById("Order123456");
        orderService.queryOrderByUserName("Aaron");
        orderService.deleteOrderByIds(Arrays.asList(new String[] {"Order123456", "Order321452"}));

    }
}
