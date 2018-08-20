package com.aaron.spring.tx;

import com.aaron.spring.ioc.User;

/**
 * JDK的动态代理实现AOP
 * 
 * @author Aaron
 * @date 2018年8月20日
 * @version 1.0
 * @package_type com.spring.tx.TestMain
 */
public class TestMain {
	public static void main(String[] args) {
		TxProxyManager manager = new TxProxyManager();
		// 创建UserService的代理对象
		IUserService userService = (IUserService) manager.getProxy(new UserServiceImpl());
		User user = new User();
		user.setAge(34);
		user.setName("张三");
		user.setPassword("123");
		user.setId(23);
		userService.addUser(user);

	}
}
