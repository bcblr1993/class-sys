package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {

	void save(User user);

	User queryUser(String username);
	
}
