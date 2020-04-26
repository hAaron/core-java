package com.aaron.framework.spring.aop;

public interface ApplicationContext {

	public Object getBean(String beanName);
	
	public <T> T getBean(String beanName,Class<?> T);
	
}
