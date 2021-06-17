package com.baizhi.service;

import com.baizhi.entity.Tag;

import java.util.List;

public interface TagService {
	
	
	
	void save(Tag tag);
	
	
	List<Tag> findAll();
	
	List<Tag> findByTagType(String type);

	void delete(int id);
}
