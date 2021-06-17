package com.baizhi.dao;

import com.baizhi.entity.Group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupDAO extends BaseDAO<Group>{
	
	
	
	List<Group> queryGroupsByClazzId(String clazzId);
	
}	
