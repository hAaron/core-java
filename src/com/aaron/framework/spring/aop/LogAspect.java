package com.aaron.framework.spring.aop;

/**
 * 日志处理，这里目的是将对数据库的操作记录下来放到文件或者数据库(定义切点和切面， 并且继承 AbsMethodAdvance)
 * 
 * @author Aaron
 * @date 2018年8月3日
 * @version 1.0
 * @package_type com.aaron.spring.aop.LogAspect
 */
@Aspect
public class LogAspect extends CglibAbsMethodAdvance {

	@Override
	public void doBefore() {
		System.out.println("--------执行PointCut切点前置操作--------");
	}

	/**
	 * 该方法就是一个标识，不进行调用
	 */
	@PointCut("com.aaron.spring.aop.UserService_delete*,com.aaron.spring.aop.OrderService_delete*")
	public void logToDB() {
	}

	@Override
	public void doAfter() {
		System.out.println("--------执行PointCut切点后置操作--------");
	}

}
