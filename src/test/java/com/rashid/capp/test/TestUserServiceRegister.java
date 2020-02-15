package com.rashid.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rashid.capp.config.SpringRootConfig;
import com.rashid.capp.dao.UserDAO;
import com.rashid.capp.domain.User;
import com.rashid.capp.service.UserService;

public class TestUserServiceRegister {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService = context.getBean(UserService.class);
	
		User user = new User();
		user.setName("Test");
		user.setPhone("0000");
		user.setEmail("test@outlook.com");
		user.setAddress("Test");
		user.setLoginName("test");
		user.setPassword("test");
		user.setRole(UserService.ROLE_ADMIN); //Admin
		user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE); //Active state
		
		userService.register(user);
		System.out.println("------------User registered succcesfully----------------");
		
	}

}
