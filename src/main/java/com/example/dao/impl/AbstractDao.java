package com.example.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.example.dao.GennericDao;
import com.example.mapper.IRowMapper;

// module DAO se chua cac cau statement SQL 
public class AbstractDao<T> implements GennericDao<T> {
	ResourceBundle bundle = ResourceBundle.getBundle("db");

	public Connection getConnection() { // khoi tao connection
		try {
			Class.forName(bundle.getString("driverName"));
			return DriverManager.getConnection(bundle.getString("url"), bundle.getString("userName"),
					bundle.getString("password"));
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters) { // tra ve danh sach cac hang
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<T> list = new ArrayList<>();
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				T t = rowMapper.mapRow(resultSet);
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) { // ep kieu cac pram
		try {
			for (int i = 0; i < parameters.length; i++) {
				int index = i + 1;
				Object element = parameters[i];
				if (element instanceof Long) {
					statement.setLong(index, (Long) element);
				} else if (element instanceof String) {
					statement.setString(index, (String) element);
				} else if (element instanceof Integer) {
					statement.setInt(index, (Integer) element);
				} else if (element instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) element);
				}
			}
		} catch (SQLException e) {
			return;
		}
	}

	@Override
	public void update(String sql, Object... parameters) { // xoa and capnhap commit and rollback
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) { // them hang return ve id vua them
		Long id = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // chu y
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next())
				id = resultSet.getLong(1);
			connection.commit();
			return id;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}
	}

}
