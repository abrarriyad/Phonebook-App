package com.rashid.capp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rashid.capp.domain.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		
		user.setUserId(rs.getInt("userId"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getNString("address"));
		user.setPhone(rs.getString("phone"));
		user.setLoginName(rs.getNString("loginName"));
		user.setRole(rs.getInt("role"));
		user.setLoginStatus(rs.getInt("loginStatus"));
		
		
		return user;
	}

}
