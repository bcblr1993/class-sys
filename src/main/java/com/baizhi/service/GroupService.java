package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Group;

/**
 * 小组的一组业务接口类
 * @author Administrator
 *
 */
public interface GroupService {

	
	void save(Group group);
	
	
	List<Group> findAll();
	
	List<Group> findByClazzId(String clazzId);
	
}
