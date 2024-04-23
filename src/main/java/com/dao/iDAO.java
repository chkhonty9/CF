package com.dao;

import java.util.List;


public interface iDAO<T> {

	void saveOrUpdate(T o);
	void delete(T o);
	T getById(int id);
	List<T> getAll();
}
