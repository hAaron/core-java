package com.aaron.framework.spring.aop;

import java.util.List;

/**
 * 业务逻辑处理类(被代理的实体类)
 * 
 * @author Aaron
 * @date 2018年8月4日
 * @version 1.0
 * @package_type com.aaron.spring.aop.OrderService
 */
public class OrderService {

    public void deleteOrderById(String orderId) {

        System.out.println("delete order by orderId, orderId: " + orderId);
    }

    public Object queryOrderByUserName(String userName) {
        Object object = null;// query
        System.out.println("find order by userName, userName: " + userName);
        return object;
    }

    public int deleteOrderByIds(List<String> orderIds) {
        System.out.println("delete order by orderIds, orderIds: " + orderIds);
        return 0;
    }
}
