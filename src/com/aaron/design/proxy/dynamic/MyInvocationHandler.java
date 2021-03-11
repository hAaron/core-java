package com.aaron.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 方法二 自定义handler 实现接口InvocationHandler
 * 
 * @author Aaron
 * @date 2018年3月24日
 * @version 1.0
 * @package_type com.aaron.design.proxy.dynamic.MyInvocationHandler
 */
public class MyInvocationHandler implements InvocationHandler {

    // 定义目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        return result;
    }

    /**
     * 获取代理对象
     * 
     * @return
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(),
            this);
    }

}
