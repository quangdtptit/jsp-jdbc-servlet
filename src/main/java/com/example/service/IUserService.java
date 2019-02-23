package com.example.service;

import com.example.model.UserModel;

public interface IUserService {
	UserModel isExits(String userName, String password, Integer status);
}
