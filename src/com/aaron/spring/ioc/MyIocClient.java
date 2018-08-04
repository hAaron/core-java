package com.aaron.spring.ioc;

/**
 * 实现ioc
 * 
 * @author Aaron
 * @date 2018年8月2日
 * @version 1.0
 * @package_type com.aaron.spring.ioc.MyIoc
 */
public class MyIocClient {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("user.xml");
		// 使用手动强转的方式获取单例的User对象
		User user1_1 = (User) applicationContext.getBean("user1");
		System.out.println("单例user1_1:" + user1_1);
		// 使用传入类对象的方式获取单例的User对象
		User user1_2 = applicationContext.getBean("user1", User.class);
		System.out.println("单例user1_2:" + user1_2);
		// 使用手动强转的方式获取多例的User对象
		User user2_1 = (User) applicationContext.getBean("user2");
		System.out.println("多例user2_1:" + user2_1);
		// 使用传入类对象的方式获取多例的User对象
		User user2_2 = applicationContext.getBean("user2", User.class);
		System.out.println("多例user2_2:" + user2_2);
		
		applicationContext.destroy();
	}

}
