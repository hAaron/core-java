package com.aaron.framework.spring.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法切入点
 * 
 * @author Aaron
 * @date 2018年8月3日
 * @version 1.0
 * @package_type com.aaron.spring.aop.PointCut
 */
@Retention(RetentionPolicy.RUNTIME) // 保留时间长短
@Target(value = { ElementType.METHOD }) // 使用范围 方法
public @interface PointCut {

	/**
	 * 全类名_方法名
	 *
	 * @return
	 */
	String value();
}
