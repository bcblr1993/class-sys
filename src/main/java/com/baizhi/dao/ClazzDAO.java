package com.baizhi.dao;

import com.baizhi.entity.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzDAO extends BaseDAO<Clazz>{
	
	
	List<Clazz> queryAllClazzAndGroups();
	
	
}	
