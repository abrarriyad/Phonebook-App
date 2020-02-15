package com.rashid.capp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.rashid.capp.dao.BaseDAO;
import com.rashid.capp.dao.UserDAO;
import com.rashid.capp.domain.User;
import com.rashid.capp.exception.UserBlockedException;
import com.rashid.capp.rm.UserRowMapper;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void register(User user) {
		userDAO.save(user);
		
	}

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		String sql = "SELECT userId, name, phone, email, address, role, loginStatus, loginName "+
					"FROM user WHERE loginName=:ln AND password=:pw";
		
		Map map = new HashMap();
		map.put("ln", loginName);
		map.put("pw", password);
		try {
		User user = getNamedParameterJdbcTemplate().queryForObject(sql, map, new UserRowMapper());
		if(user.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
			throw new UserBlockedException("Your account has been blocked.Contact to admin");
		}
		else
			return user;
	
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<User> getUserList() {
		return userDAO.findByProperty("role", UserService.ROLE_USER);
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		String sql = "UPDATE user SET loginStatus=:lst WHERE userId=:uid";
		
		Map map = new HashMap();
		map.put("lst", loginStatus);
		map.put("uid", userId);
		
		getNamedParameterJdbcTemplate().update(sql,map);
	}

	@Override
	public Boolean isUserNameExist(String username) {
		String sql="SELECT count(loginName) FROM user WHERE loginName=?";
		Integer count =  getJdbcTemplate().queryForObject(sql,new String[] {username},Integer.class);
		if(count==1) {
			return true;
		}else {
			return false;
		}
	}

}
