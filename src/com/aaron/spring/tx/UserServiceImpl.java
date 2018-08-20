package com.aaron.spring.tx;

import com.aaron.spring.ioc.User;

public class UserServiceImpl implements IUserService {

	@Override
	public void addUser(User user) {
		System.out.println("执行dao的新增操作,添加一个用户:" + user);
	}

	@Override
	public void delUser(String name) {
		System.out.println("执行dao的删除操作,删除一个用户:" + name);
	}

	@Override
	public void findUser() {
		System.out.println("执行dao的查询,查询全部用户");
	}

}
