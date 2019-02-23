package com.example.dao;

import java.util.List;

import com.example.model.NewsModel;
import com.example.paging.Pageble;

public interface INewsDao extends GennericDao<NewsModel>{
	List<NewsModel> findByCategoryId(Long id);
	List<NewsModel> findAll();
	Long save(NewsModel newsModel);
	void update(NewsModel newsModel);
	void delete(Long id);
	NewsModel findOne(Long id);
	int getCount();
	List<NewsModel> findItemOnAPage(Pageble pageble);
}
