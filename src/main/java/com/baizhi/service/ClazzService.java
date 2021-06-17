package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Clazz;

public interface ClazzService {


	void save(Clazz clazz);
	
	
	List<Clazz> findAll();
	
	
	List<Clazz> findClazzAndGroups();
	
	
	
}	
