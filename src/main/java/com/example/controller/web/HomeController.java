package com.example.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.UserModel;
import com.example.security.Authentication;
import com.example.utils.FormUtil;
import com.example.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/login" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action.equals("signin")) {
			UserModel userModel = FormUtil.toModel(UserModel.class, req);
			String url = Authentication.of(userModel.getUserName(), userModel.getPassword()).urlRediect(req);
			resp.sendRedirect(req.getContextPath() + url);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals("signin")) {
				if (req.getParameter("user") != null) {
					req.setAttribute("message", "Tài khoản hoặc mật khẩu sai !");
					req.setAttribute("alert", "danger");
				}
				RequestDispatcher rd = req.getRequestDispatcher("/views/login/signin.jsp");
				rd.forward(req, resp);
			} else if (action.equals("signup")) {
				RequestDispatcher rd = req.getRequestDispatcher("/views/login/signup.jsp");
				rd.forward(req, resp);
			} else if (action.equals("forget")) {
				RequestDispatcher rd = req.getRequestDispatcher("/views/login/forget.jsp");
				rd.forward(req, resp);
			} else if (action.equals("logout")) {
				SessionUtil.getInstance().removeValue(req, "USERMODEL");
				resp.sendRedirect(req.getContextPath() + "/trang-chu");
			}
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);
		}
	}
}
