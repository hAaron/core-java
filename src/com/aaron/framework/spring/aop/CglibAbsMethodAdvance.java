package com.aaron.framework.spring.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib
 * 
 * @author Aaron
 * @date 2018年8月3日
 * @version 1.0
 * @package_type com.aaron.spring.aop.CglibAbsMethodAdvance
 */
public abstract class CglibAbsMethodAdvance implements MethodInterceptor {

    /**
     * 要被代理的目标对象
     */
    private Object targetObject;

    /**
     * 被代理的方法名
     */
    private String proxyMethodName;

    /**
     * 给目标对象创建代理对象
     */
    public Object getProxyInstance(Object targetObject) {
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(targetObject.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类(代理对象)
        return enhancer.create();

    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = null;
        // 正则表达式去除通配符* 使用\\*
        String proxyMethod = getProxyMethodName().replaceAll("\\*", "");

        if (proxyMethod != null && method.getName().contains(proxyMethod)) {
            doBefore();
        }

        // 根据定义的切点，执行相应的拦截操作
        // if (proxyMethod != null && proxyMethod.equals(method.getName())) {
        // System.out.println("删除操作数据库行为被记录到本地：" + proxyMethod);
        // }
        if (proxyMethod != null && method.getName().contains(proxyMethod)) {
            System.out.println("删除操作数据库行为被记录到本地：" + method.getName());
        }

        // 执行被代理对象自己的方法
        result = proxy.invokeSuper(obj, args);

        if (proxyMethod != null && method.getName().contains(proxyMethod)) {
            doAfter();
        }
        return result;
    }

    public abstract void doBefore();

    public abstract void doAfter();

    public String getProxyMethodName() {
        return proxyMethodName;
    }

    public void setProxyMethodName(String proxyMethodName) {
        this.proxyMethodName = proxyMethodName;
    }

    public static void main(String[] args) {
        String de = "delete*";
        System.out.println(de.replaceAll("\\*", ""));
    }
}
