package org.nagarro.service;

import org.nagarro.model.User;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {	
	
	public User doLogin(User user) {
		System.out.println("Welcome to login service");
		if(user.getUsername() == "admin") {
			if(user.getPassword() == "admin") {
				System.out.println("Hi welcome : "+ user.getUsername());
			}
		}
		return user;
	}

}
