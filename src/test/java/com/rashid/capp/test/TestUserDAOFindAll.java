package com.rashid.capp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rashid.capp.config.SpringRootConfig;
import com.rashid.capp.dao.UserDAO;
import com.rashid.capp.domain.User;

public class TestUserDAOFindAll {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = context.getBean(UserDAO.class);
		
		List <User> users = userDAO.findAll();
		
		System.out.println("----------------All Users-------------------");
		
		for(User user: users) {	
			
		System.out.println(user.getUserId()+" "+ user.getName() + " "+ user.getPhone()+" "+user.getEmail()+" "+ user.getAddress()+" "+
		user.getLoginName()+" "+ user.getRole()+" "+user.getLoginName());
		
		}

	}

}
