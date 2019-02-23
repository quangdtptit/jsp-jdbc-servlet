package com.example.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.example.builder.NewsBuilder;
import com.example.dao.ICategoryDao;
import com.example.dao.INewsDao;
import com.example.model.CategoryModel;
import com.example.model.NewsModel;
import com.example.paging.Pageble;
import com.example.service.INewsService;

public class NewsService implements INewsService {

	@Inject
	private INewsDao newsDao;

	@Inject
	private ICategoryDao categoryDao;

	@Override
	public List<NewsModel> findAll() {
		return newsDao.findAll();
	}

	@Override
	public List<NewsModel> findByCategoryId(Long id) {
		return newsDao.findByCategoryId(id);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newsModel.setCreatedBy("");
		Long id = newsDao.save(newsModel);
		return newsDao.findOne(id);
	}

	@Override
	public void update(NewsModel newsModel) {
		NewsModel newsModel1 = newsDao.findOne(newsModel.getId());
		newsModel.setCreatedBy(newsModel1.getCreatedBy());
		newsModel.setCreatedDate(newsModel1.getCreatedDate());
		newsModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		newsModel.setModifiedBy("");
		newsDao.update(newsModel);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			newsDao.delete(id);
		}
	}

	@Override
	public int getCount() {
		return newsDao.getCount();
	}

	@Override
	public List<NewsModel> findItemOnAPage(NewsBuilder builder,Pageble pageble) {
		return newsDao.findItemOnAPage(pageble);
	}

	@Override
	public NewsModel findOne(Long id) {
		NewsModel newsModel = newsDao.findOne(id);
		CategoryModel categoryModel = categoryDao.findOne(newsModel.getCategoryId());
		newsModel.setCategoryCode(categoryModel.getCode());
		return newsModel;
	}

}
