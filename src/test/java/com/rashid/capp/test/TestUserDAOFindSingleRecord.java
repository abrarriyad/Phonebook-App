package com.rashid.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rashid.capp.config.SpringRootConfig;
import com.rashid.capp.dao.UserDAO;
import com.rashid.capp.domain.User;

public class TestUserDAOFindSingleRecord {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);
		
		User user =userDAO.findById(4);
		
		System.out.println("----------------User Details-------------------");
		System.out.println(user.getUserId());
		System.out.println(user.getEmail());
		System.out.println(user.getAddress());
		System.out.println(user.getLoginName());
		System.out.println(user.getPhone());
		System.out.println(user.getRole());
		System.out.println(user.getLoginStatus());
		
		

	}

}
