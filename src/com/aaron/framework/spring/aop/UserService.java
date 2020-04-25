package com.aaron.framework.spring.aop;

/**
 * 业务逻辑处理类(被代理的实体类)
 * 
 * @author Aaron
 * @date 2018年8月3日
 * @version 1.0
 * @package_type com.aaron.spring.aop.UserService
 */
public class UserService {

	public void deleteUserById(String userId) {
		// delete db
		System.out.println("delete user by userid from db " + userId);
	}

	public void deleteAll() {
		// delete db
		System.out.println("delete all user by userid from db ");
	}

	public Object findUserById(String userId) {
		Object object = null;// find user from db
		System.out.println("find user by userid from db " + userId);
		return object;
	}

}
