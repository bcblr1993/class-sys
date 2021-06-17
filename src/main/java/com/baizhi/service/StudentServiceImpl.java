package com.baizhi.service;

import com.baizhi.dao.GroupDAO;
import com.baizhi.dao.StudentDAO;
import com.baizhi.dao.StudentTagDAO;
import com.baizhi.entity.Student;
import com.baizhi.entity.StudentTag;
import com.baizhi.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private StudentTagDAO studentTagDAO;

    @Autowired
    private GroupDAO groupDAO;

    public void save(Student student, String clazzGroupId, List<String> tags) {
        //处理年龄
        student.setAge(DateUtil.getAge(student.getBir()));
        //处理星座
        student.setStarts(DateUtil.getConstellation(student.getBir()));
        //处理生肖
        student.setAttr(DateUtil.getYear(student.getBir()));

        String[] ids = clazzGroupId.split("#");//第一个班级id 第二个小组id
        student.getClazz().setId(ids[0]);//维护班级外键
        student.getGroup().setId(ids[1]);//维护小组外键

        //取出前台备注文本域中前后存在的空格
        student.setMark(student.getMark().trim());

        studentDAO.save(student);//保存学生


        for (String tid : tags) {//保存多个学生标签
            StudentTag studentTag = new StudentTag(student.getId(), tid);
            studentTagDAO.save(studentTag);
        }
    }



    public List<Student> findAll(Integer page,Integer rows,String colName,String colValue) {
        int start = (page-1)*rows;
        return studentDAO.queryByPage(start, rows, colName, colValue);
    }


    @Override
    public Long queryTotalCount(String colName,String colValue) {
        return studentDAO.queryTotalCount(colName,colValue);
    }

    public Student findOneStudentById(String id) {
        return studentDAO.queryOneStudentById(id);
    }

    public void update(Student student, String clazzGroupId, List<String> tags) {
        //更新年龄
        student.setAge(DateUtil.getAge(student.getBir()));
        //更新星座和生肖
        student.setStarts(DateUtil.getConstellation(student.getBir()));
        student.setAttr(DateUtil.getYear(student.getBir()));
        //去掉前台文本域中存在前后空格
        student.setMark(student.getMark().trim());
        //维护学生与班级关系
        student.getClazz().setId(clazzGroupId.split("#")[0]);
        //维护学生与小组关系
        student.getGroup().setId(clazzGroupId.split("#")[1]);
        studentDAO.update(student);

        //删除学生原有标签
        studentTagDAO.delete(Integer.valueOf(student.getId()));
        //添加学生标签
        for (String tagId : tags) {
            StudentTag studentTag = new StudentTag(student.getId(), tagId);
            studentTagDAO.save(studentTag);
        }
    }

    public void delete(String id) {
        //解除学生与标签之间的关系
        studentTagDAO.delete(Integer.valueOf(id));
        //删除学生
        studentDAO.delete(Integer.valueOf(id));
   }

}
