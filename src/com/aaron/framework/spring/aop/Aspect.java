package com.aaron.framework.spring.aop;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 切面
 * @author Aaron
 * @date 2018年8月3日
 * @version 1.0
 * @package_type com.aaron.spring.aop.Aspect
 */
@Retention(RetentionPolicy.RUNTIME)//保留时间长短
@Target(value = {ElementType.TYPE})//使用范围 接口、类、枚举、注解
public @interface Aspect {
}
