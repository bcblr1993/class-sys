package com.baizhi.dao;

import com.baizhi.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface StudentDAO extends BaseDAO<Student>{
	
	
	
	
	List<Student> queryByGroupId(String groupId);
	
	
	Student queryOneStudentById(String id);


	//分页查询
    List<Student> queryByPage(@Param("start") int start, @Param("rows") Integer rows,@Param("colName") String colName,@Param("colValue") String colValue);

    //查询总条数
    Long  queryTotalCount(@Param("colName") String colName,@Param("colValue") String colValue);
}
