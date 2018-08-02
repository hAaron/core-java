package com.aaron.spring.ioc;

public interface ApplicationContext {

	public <T> T getBean(String beanId, Class<T> c);

	public Object getBean(String beanId);

}
