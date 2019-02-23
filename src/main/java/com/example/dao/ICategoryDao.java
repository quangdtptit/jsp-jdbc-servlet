package com.example.dao;

import java.util.List;

import com.example.model.CategoryModel;

public interface ICategoryDao extends GennericDao<CategoryModel> {
	List<CategoryModel> findAll(); 
	Long save(CategoryModel categoryModel);
	void delete(long id);
	void update(CategoryModel newCategory);
	CategoryModel findOne(Long id);
}
