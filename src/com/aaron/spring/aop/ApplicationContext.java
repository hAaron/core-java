package com.aaron.spring.aop;

public interface ApplicationContext {

	public Object getBean(String beanName);
	
	public <T> T getBean(String beanName,Class<?> T);
	
}
