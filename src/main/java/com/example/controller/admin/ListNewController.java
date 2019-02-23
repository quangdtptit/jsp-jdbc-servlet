package com.example.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.builder.NewsBuilder;
import com.example.constant.WebConstant;
import com.example.model.CategoryModel;
import com.example.model.NewsModel;
import com.example.paging.PageRequest;
import com.example.paging.Pageble;
import com.example.service.ICategoryService;
import com.example.service.impl.NewsService;
import com.example.sort.Sorter;
import com.example.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-news" })
public class ListNewController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private NewsService newsService;

	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsModel newsModel = FormUtil.toModel(NewsModel.class, req);
		String view = null;
		if (newsModel.getType().equals(WebConstant.LIST)) {
			view = "/views/admin/news/list.jsp";
			newsModel.setTotalItem(newsService.getCount());
			newsModel.setTotalPages((int) Math.ceil((double) newsModel.getTotalItem() / newsModel.getMaxPageItem()));
			Pageble pageble = new PageRequest(newsModel.getPage(), newsModel.getMaxPageItem(),
					new Sorter(newsModel.getElementSort(), newsModel.getSortBy()));
			NewsBuilder builder = new NewsBuilder.Buider().setTitle(newsModel.getTitle())
					.setCategoryCode(newsModel.getCategoryCode()).setView(newsModel.getView()).build();
			newsModel.setList(newsService.findItemOnAPage(builder, pageble));
		} else if (newsModel.getType().equals(WebConstant.EDIT)) {
			if (newsModel.getId() != null) {
				newsModel = newsService.findOne(newsModel.getId());
			}
			view = "/views/admin/news/edit.jsp";
		}
		List<CategoryModel> categorys = categoryService.findAll();
		req.setAttribute("categorys", categorys);
		req.setAttribute(WebConstant.MODEL, newsModel);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
