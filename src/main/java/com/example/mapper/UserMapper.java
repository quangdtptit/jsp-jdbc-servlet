package com.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.RoleModel;
import com.example.model.UserModel;

public class UserMapper implements IRowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel userModel = new UserModel();
			userModel.setUserName(rs.getString("username"));
			userModel.setId(rs.getLong("id"));
			userModel.setPassword(rs.getString("password"));
			userModel.setFullName(rs.getString("fullname"));
			userModel.setStatus(rs.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(rs.getString("code"));
				role.setName(rs.getString("name"));
				userModel.setRole(role);
			} catch (SQLException e) {

			}
			return userModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
