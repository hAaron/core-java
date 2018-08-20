package com.aaron.spring.tx;

import com.aaron.spring.ioc.User;

public interface IUserService {
	
	public void addUser(User user);
	
	public void delUser(String name);
	
	public void findUser();

}
