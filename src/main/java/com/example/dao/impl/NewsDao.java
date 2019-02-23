package com.example.dao.impl;

import java.util.List;

import com.example.dao.INewsDao;
import com.example.mapper.NewsMapper;
import com.example.model.NewsModel;
import com.example.paging.Pageble;

public class NewsDao extends AbstractDao<NewsModel> implements INewsDao {

	@Override
	public List<NewsModel> findByCategoryId(Long id) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewsMapper(), id);
	}

	@Override
	public List<NewsModel> findAll() {
		String sql = "SELECT * FROM news";
		return this.query(sql, new NewsMapper());
	}

	@Override
	public Long save(NewsModel newsModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news(title,content, thumbnail,shortdescription");
		sql.append(",categoryid,createdDate,createdBy)");
		sql.append(" VALUES (?,?,?,?,?,?,?)");
		return this.insert(sql.toString(), newsModel.getTitle(), newsModel.getContent(), newsModel.getThumbnail(),
				newsModel.getShortDescription(), newsModel.getCategoryId(), newsModel.getCreatedDate(),
				newsModel.getCreatedBy());
	}

	@Override
	public void update(NewsModel newsModel) {
		String sql = "UPDATE news SET title=?," + "content=? , thumbnail=? ,shortdescription=?,"
				+ "categoryid =?, createdDate =? ,modifiedDate =?,createdBy=?," + "modifiedBy=? WHERE id = ?";
		this.update(sql, newsModel.getTitle(), newsModel.getContent(), newsModel.getThumbnail(),
				newsModel.getShortDescription(), newsModel.getCategoryId(), newsModel.getCreatedDate(),
				newsModel.getModifiedDate(), newsModel.getCreatedBy(), newsModel.getModifiedBy(), newsModel.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM news WHERE id=?";
		this.update(sql, id);
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "SELECT * FROM news  WHERE id =?";
		List<NewsModel> list = this.query(sql, new NewsMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public int getCount() {
		String sql = "SELECT COUNT(*) FROM news";
		return this.count(sql);
	}

	@Override
	public List<NewsModel> findItemOnAPage(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if (pageble.getSorter().getElementSort() != null && pageble.getSorter().getSortBy() != null) {
			sql.append(" ORDER BY ").append(pageble.getSorter().getElementSort()).append(" ").append(pageble.getSorter().getSortBy());
		}
		// String sql = "SELECT * FROM news LIMIT ?,?";
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT "+pageble.getOffset()+","+pageble.getLimit());
		} 
		return this.query(sql.toString(), new NewsMapper());
	}

}
