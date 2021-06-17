package com.baizhi.dao;

import com.baizhi.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



@Mapper
public interface TagDAO extends BaseDAO<Tag>{

	
	List<Tag> queryByTagType(String type);


	void delete(int id);
	
}
