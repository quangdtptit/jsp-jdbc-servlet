package com.example.dao.impl;

import java.util.List;

import com.example.dao.IUserDao;
import com.example.mapper.UserMapper;
import com.example.model.UserModel;

public class UserDao extends AbstractDao<UserModel> implements IUserDao {

	@Override
	public UserModel isExits(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON u.roleid = r.id");
		sql.append(" WHERE u.username =? AND u.password=? AND u.status=?");
		List<UserModel> list = this.query(sql.toString(), new UserMapper(), userName, password, status);
		if(list.size()==0)
			return null;
		else
			return list.get(0);
	}
}
