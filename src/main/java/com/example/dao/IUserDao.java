package com.example.dao;

import com.example.model.UserModel;

public interface IUserDao extends GennericDao<UserModel>{
	UserModel isExits(String userName , String password, Integer status);
}
