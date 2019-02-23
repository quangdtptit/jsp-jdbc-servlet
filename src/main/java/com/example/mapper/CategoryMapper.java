package com.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.CategoryModel;

public class CategoryMapper implements IRowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		try {
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.setId(rs.getLong("id"));
			categoryModel.setCode(rs.getString("code"));
			categoryModel.setName(rs.getString("name"));
			categoryModel.setCreatedDate(rs.getTimestamp("createddate"));
			categoryModel.setCreatedBy(rs.getString("createdby"));
			if (rs.getTimestamp("modifieddate") != null)
				categoryModel.setModifiedDate(rs.getTimestamp("modifieddate"));
			if (rs.getString("modifiedby") != null)
				categoryModel.setModifiedBy(rs.getString("modifiedby"));
			return categoryModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
