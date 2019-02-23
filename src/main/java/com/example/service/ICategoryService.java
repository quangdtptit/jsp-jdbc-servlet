package com.example.service;

import java.util.List;

import com.example.model.CategoryModel;

// module service su chua cac xuly logic 
public interface ICategoryService {
	List<CategoryModel> findAll();
	Long save(CategoryModel categoryModel);
	void delete(long[] ids);
	CategoryModel findOne(Long id);
}
