package com.aaron.spring.ioc;

public interface ApplicationContext {

	public <T> T getBean(String beanId, Class<T> c);

	public Object getBean(String beanId);

	/**
	 * 销毁方法，用于释放资源
	 */
	public void destroy();

}
