package com.baizhi.service;

import com.baizhi.entity.Student;

import java.util.List;

public interface StudentService {
	
	
	void save(Student student, String clazzGroupId, List<String> tags);
	
	void update(Student student, String clazzGroupId, List<String> tags);
	
	List<Student> findAll(Integer page,Integer rows,String colName,String colValue);

	Long  queryTotalCount(String colName,String colValue);
	
	Student findOneStudentById(String id);
	
	void delete(String id);
	
}
