package com.kpc.model;

import java.sql.SQLException;
import java.util.List;

public interface DeptDao<T> {
	List<T> selectAll() throws SQLException;
	T selectOne(int pk) throws SQLException;
	void editInsert(T t) throws SQLException;
	int editUpdate(T t) throws SQLException;
	int editDelete(int pk) throws SQLException;
}
