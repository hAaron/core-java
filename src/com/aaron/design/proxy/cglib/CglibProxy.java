package com.aaron.design.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * * Cglib子类代理工厂 在内存中动态构建一个子类对象
 * 
 * @author Aaron
 * @date 2018年3月24日
 * @version 1.0
 * @package_type com.aaron.design.proxy.cglib.CglibProxy
 */
public class CglibProxy implements MethodInterceptor {

    // 目标对象
    private Object target;

    public CglibProxy(Object target) {
        super();
        this.target = target;
    }

    /**
     * 给目标对象创建一个代理对象
     * 
     * @return
     */
    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类(代理对象)
        return enhancer.create();

    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("开始");
        // 执行目标对象的方法
        Object object = proxy.invokeSuper(obj, args);
        System.out.println("结束");
        return object;
    }

}
