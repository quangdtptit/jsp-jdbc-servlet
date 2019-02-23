package com.example.service.impl;

import com.example.dao.IUserDao;
import com.example.dao.impl.UserDao;
import com.example.model.UserModel;
import com.example.service.IUserService;

public class UserService implements IUserService {
	private IUserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}

	@Override
	public UserModel isExits(String userName, String password, Integer status) {
		return userDao.isExits(userName, password, status);
	}

}
