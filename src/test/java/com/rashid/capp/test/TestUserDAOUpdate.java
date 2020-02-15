package com.rashid.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rashid.capp.config.SpringRootConfig;
import com.rashid.capp.dao.UserDAO;
import com.rashid.capp.domain.User;

public class TestUserDAOUpdate {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);
	
		User user = new User();
		user.setUserId(2);
		user.setName("Gomej");
		user.setPhone("0178797979");
		user.setEmail("gomej@outlook.com");
		user.setAddress("Narayanganj");
		user.setRole(2); //Admin
		user.setLoginStatus(1); //Active state
		
		userDAO.update(user);
		
		System.out.println("-------------Data Updated-----------------");

	}

}
