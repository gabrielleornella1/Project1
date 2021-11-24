package com.example.dao;

public interface GenericDao <T>{
	
	boolean update(T entity);
	boolean insert(T entity);
	void delete(T entity);

}
