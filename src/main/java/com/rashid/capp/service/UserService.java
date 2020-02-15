package com.rashid.capp.service;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.rashid.capp.domain.User;
import com.rashid.capp.exception.UserBlockedException;

public interface UserService {
	
	public static final Integer LOGIN_STATUS_ACTIVE = 1;
	public static final Integer LOGIN_STATUS_BLOCKED = 2;
	
	public static Integer ROLE_ADMIN=1;
	public static Integer ROLE_USER=2;
	
	public void register(User user);
	public User login(String loginName, String password) throws UserBlockedException;
	public List<User> getUserList();
	public void changeLoginStatus(Integer userId, Integer loginStatus);
	
	public Boolean isUserNameExist(String username);
	

}
