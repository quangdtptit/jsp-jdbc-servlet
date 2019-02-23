package com.example.security;

import javax.servlet.http.HttpServletRequest;

import com.example.model.UserModel;
import com.example.service.IUserService;
import com.example.service.impl.UserService;
import com.example.utils.SessionUtil;

public class AuthenticationImpl implements Authentication {
	private String userName;
	private String password;
	private IUserService userService;

	public AuthenticationImpl(String userName, String password) {
		this.userName = userName;
		this.password = password;
		userService = new UserService();
	}

	@Override
	public String urlRediect(HttpServletRequest req) {
		UserModel userModel = userService.isExits(this.userName, this.password, 1);
		try {
			userModel = userService.isExits(userModel.getUserName(), userModel.getPassword(), 1);
		} catch (NullPointerException e) {
			return "/login?action=signin&user=null";
		}
		if (userModel != null) {
			SessionUtil.getInstance().putValue(req, "USERMODEL", userModel);
			if (userModel.getRole().getCode().equals("ADMIN")) {
				return "/admin-home";
			} else if (userModel.getRole().getCode().equals("USER")) {
				return "/trang-chu";
			}
		}
		return "/login?action=signin&user=null";
	}
}
