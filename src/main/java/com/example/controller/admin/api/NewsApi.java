package com.example.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.NewsModel;
import com.example.service.INewsService;
import com.example.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewsApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * 
	 * }
	 */

	@Inject
	private INewsService newsService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class); // json to object
		newsModel = newsService.save(newsModel);
		objectMapper.writeValue(resp.getOutputStream(), newsModel); // ghi ra postman object to json
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		// newsModel.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(req,
		// "USERMODEL")).getUserName());
		newsService.update(newsModel);
		objectMapper.writeValue(resp.getOutputStream(), newsModel); // ghi ra postman object to json
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		newsService.delete(newsModel.getIds());
		objectMapper.writeValue(resp.getOutputStream(), "{ }");
	}
}
