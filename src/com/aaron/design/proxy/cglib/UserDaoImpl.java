package com.aaron.design.proxy.cglib;

/**
 * 目标对象，没有接口实现
 * 
 * @author Aaron
 * @date 2018年3月24日
 * @version 1.0
 * @package_type com.aaron.design.proxy.cglib.UserDaoImpl
 */
public class UserDaoImpl {

    public void addUser() {
        System.out.println("新增用户>>>>>>>>>>");
    }

}
