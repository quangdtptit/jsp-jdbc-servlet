package com.example.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.example.dao.ICategoryDao;
import com.example.model.CategoryModel;
import com.example.service.ICategoryService;

public class CategoryService implements ICategoryService {

	/*
	 * private ICategoryDao categoryDao;
	 * 
	 * public CategoryService() { categoryDao = new CategoryDao(); }
	 */

	@Inject
	private ICategoryDao categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public Long save(CategoryModel categoryModel) {
		return this.categoryDao.save(categoryModel);
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids)
			this.categoryDao.delete(id);
	}

	@Override
	public CategoryModel findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
