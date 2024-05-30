package com.kpc.sts04.model;

import java.util.List;

public interface DeptDao<T> {
	List<T> selectAll();
	T select(int pk);
	void insertOne(T t);
	int updateOne(T t);
	int deleteOne(int pk);
}
