package com.baizhi.service;

import com.baizhi.dao.GroupDAO;
import com.baizhi.dao.StudentDAO;
import com.baizhi.entity.Group;
import com.baizhi.entity.Student;
import com.baizhi.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDAO groupDAO;

	@Autowired
	private StudentDAO studentDAO;

	public void save(Group group) {
			group.setCreateDate(new Date());
			groupDAO.save(group);
	}

	public List<Group> findAll() {
		List<Group> groups = groupDAO.queryAll();
		//根据组获取每个组的所有学生信息
		groups.forEach(group->{
			//每次遍历组的时候创建一个新的map结构  以保证本次比较的结果准确
			Map<String,Integer> maps = new HashMap<String,Integer>();
			List<Student> students = studentDAO.queryByGroupId(group.getId());
			students.forEach(student ->{//遍历每个学生的标签集合
				//获取每一个学生的标签集合
				List<Tag> tags = student.getTags();
				tags.forEach(tag->{
					if(!maps.containsKey(tag.getName())){
						maps.put(tag.getName(),1);
					}else{
						maps.put(tag.getName(), (maps.get(tag.getName())+1));
					}
				});
			});
			//当前组中学生数量与这个标签的
			maps.forEach((key,value)->{
				if(value.equals(students.size())){
					//当前这个标签就是组的标签
					group.getTagNames().add(key);
				}
			});
			//设置小组学生数量
			group.setStuCounts(students.size());
		});
//		for (Group group : groups) {
//			//每次遍历组的时候创建一个新的map结构  以保证本次比较的结果准确
//			Map<String,Integer> maps = new HashMap<String,Integer>();
//			List<Student> students = studentDAO.queryByGroupId(group.getId());
//			//遍历每个学生的标签集合
//			for (Student student : students) {
//				//获取每一个学生的标签集合
//				List<Tag> tags = student.getTags();
//				for (Tag tag : tags) {
//					if(maps.containsKey(tag.getName())){
//						maps.put(tag.getName(),1);
//					}else{
//						maps.put(tag.getName(), (maps.get(tag.getName())+1));
//					}
//				}
//			}
//			//当前组中学生数量与这个标签的
//			for (Map.Entry<String, Integer> entry : maps.entrySet()) {
//				 if(entry.getValue().equals(students.size())){
//					 //当前这个标签就是组的标签
//					 group.getTagNames().add(entry.getKey());
//				 }
//			}
//		}
		return groups;
	}
	public List<Group> findByClazzId(String clazzId) {
		return  groupDAO.queryGroupsByClazzId(clazzId);
	}

}
