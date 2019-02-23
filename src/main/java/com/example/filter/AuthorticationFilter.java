package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.UserModel;
import com.example.utils.SessionUtil;

public class AuthorticationFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.setContext(filterConfig.getServletContext());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		if (uri.startsWith(req.getContextPath()+"/admin")) {
			UserModel userModel = (UserModel) (SessionUtil.getInstance().getValue(req, "USERMODEL"));
			if (userModel != null) {
				if (userModel.getRole().getCode().equals("ADMIN")) {
					chain.doFilter(request, response);
				} else if (userModel.getRole().getCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/login?action=signin&user=null");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/login?action=signin&user=null");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

}
