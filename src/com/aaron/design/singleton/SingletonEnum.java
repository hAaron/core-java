package com.aaron.design.singleton;

/**
 * 懒汉式 --枚举
 * 
 * 访问枚举实例时会执行构造方法，同时每个枚举实例都是static final类型的，也就表明只能被实例化一次。
 * 在调用构造方法时单例被实例化,也就是说，因为enum中的实例被保证只会被实例化一次，所以我们的INSTANCE也被保证实例化一次。
 * 
 * @author Aaron
 * @date 2017年6月1日
 * @version 1.0
 * @package_name com.aaron.design.singleton
 */
class SingletonResource {

    SingletonResource() {
        System.out.println("懒汉式--枚举");
    }

}

public enum SingletonEnum {

    INSTANCE;

    private SingletonResource resource;

    SingletonEnum() {
        resource = new SingletonResource();

    }

    public SingletonResource getInstance() {
        return resource;
    }

}
