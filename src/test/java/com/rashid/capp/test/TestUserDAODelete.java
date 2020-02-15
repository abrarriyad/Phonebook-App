package com.rashid.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rashid.capp.config.SpringRootConfig;
import com.rashid.capp.dao.UserDAO;
import com.rashid.capp.domain.User;

public class TestUserDAODelete {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);
		
		User user = new User();
		
		user.setUserId(3);
		
		userDAO.delete(user);
		
		System.out.println("-------------Data Deleted-----------------");

	}

}
