package com.example.dao;

import java.util.List;

import com.example.mapper.IRowMapper;

public interface GennericDao<T> {
	List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);
	void update(String sql, Object... parameters);
	Long insert(String sql, Object... parameters);
	int count(String sql,Object... parameters);
}
