package com.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.NewsModel;

public class NewsMapper implements IRowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet rs) {
		try {
			NewsModel newsModel = new NewsModel();
			newsModel.setId(rs.getLong("id"));
			newsModel.setTitle(rs.getString("title"));
			newsModel.setContent(rs.getString("content"));
			newsModel.setCategoryId(rs.getInt("categoryid"));
			newsModel.setShortDescription(rs.getString("shortdescription"));
			newsModel.setThumbnail(rs.getString("thumbnail"));
			newsModel.setCreatedDate(rs.getTimestamp("createddate"));
			newsModel.setCreatedBy(rs.getString("createdby"));
			newsModel.setView(rs.getInt("view"));
			if (rs.getTimestamp("modifieddate") != null)
				newsModel.setModifiedDate(rs.getTimestamp("modifieddate"));
			if (rs.getString("modifiedby") != null)
				newsModel.setModifiedBy(rs.getString("modifiedby"));
			return newsModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
