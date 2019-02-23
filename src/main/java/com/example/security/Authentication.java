package com.example.security;

import javax.servlet.http.HttpServletRequest;

public interface Authentication {
	String urlRediect(HttpServletRequest req);
	static Authentication of(String userName, String password) {
		return new AuthenticationImpl(userName , password);
	}
}
