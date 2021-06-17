package com.baizhi.service;

import com.baizhi.dao.ClazzDAO;
import com.baizhi.dao.StudentDAO;
import com.baizhi.entity.Clazz;
import com.baizhi.entity.Group;
import com.baizhi.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClazzServiceImpl  implements ClazzService{

	@Autowired
	private ClazzDAO clazzDAO;

	@Autowired
	private StudentDAO studentDAO;
	
	public void save(Clazz clazz) {
		clazzDAO.save(clazz);//保存班级
	}

	public List<Clazz> findAll() {
		return clazzDAO.queryAll();
	}

	public List<Clazz> findClazzAndGroups() {
		List<Clazz> clazzAndGroups = clazzDAO.queryAllClazzAndGroups();
		clazzAndGroups.forEach(clazz -> {
			List<Group> groups = clazz.getGroups();
			groups.forEach(group -> {
				List<Student> students = studentDAO.queryByGroupId(group.getId());
				group.setStuCounts(students.size());
			});
		});
		return clazzAndGroups;
	}

	public void delete(String id) {
		
	}

}
