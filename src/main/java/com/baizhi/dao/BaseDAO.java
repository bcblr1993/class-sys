package com.baizhi.dao;

import java.util.List;

/**
 * 一组通用的DAO接口
 * @author Administrator
 *
 * @param <T>
 */
public interface BaseDAO<T> {

	
	void save(T t);
	
	void update(T t);
	
	void delete(Integer id);
	
	T queryById(Integer id);
	
	List<T> queryAll();
	
	
}
