package com.example.dao.impl;

import java.util.List;

import com.example.dao.ICategoryDao;
import com.example.mapper.CategoryMapper;
import com.example.model.CategoryModel;

public class CategoryDao extends AbstractDao<CategoryModel> implements ICategoryDao {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return this.query(sql, new CategoryMapper());
	}

	@Override
	public Long save(CategoryModel categoryModel) {
		String sql = "INSERT INTO category(name,code,createddate,createdby) VALUES(?,?,?,?)";
		return this.insert(sql, categoryModel.getName(), categoryModel.getCode(), categoryModel.getCreatedDate(),
				categoryModel.getCreatedBy());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM category WHERE id=?";
		this.update(sql, id);
	}

	@Override
	public void update(CategoryModel newCategory) {
		String sql = "UPDATE category SET name= ? , code =? , modifieddate=?, modifiedby =? WHERE id =?";
		this.update(sql, newCategory.getName(), newCategory.getCode(), newCategory.getModifiedDate(),
				newCategory.getModifiedBy(), newCategory.getId());
	}

	@Override
	public CategoryModel findOne(Long id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> list = this.query(sql, new CategoryMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}
}
