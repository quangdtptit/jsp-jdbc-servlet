package com.example.service;

import java.util.List;

import com.example.builder.NewsBuilder;
import com.example.model.NewsModel;
import com.example.paging.Pageble;

public interface INewsService {
	List<NewsModel> findAll();
	List<NewsModel> findByCategoryId(Long id);
	NewsModel save(NewsModel newsModel);
	void update(NewsModel newsModel);
	void delete(Long[] ids);
	int getCount();
	List<NewsModel> findItemOnAPage(NewsBuilder builder,Pageble pageble);
	NewsModel findOne(Long id);
}
