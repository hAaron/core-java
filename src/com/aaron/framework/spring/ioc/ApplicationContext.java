package com.aaron.framework.spring.ioc;

/**
 * 
 * @author Aaron
 * @date 2019年4月19日
 * @version 1.0
 * @package_type com.aaron.spring.ioc.ApplicationContext
 */
public interface ApplicationContext {

	public <T> T getBean(String beanId, Class<T> c);

	public Object getBean(String beanId);

	/**
	 * 销毁方法，用于释放资源
	 */
	public void destroy();

}
