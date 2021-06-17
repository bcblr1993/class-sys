package com.baizhi.controller;

import com.baizhi.entity.City;
import com.baizhi.entity.Clazz;
import com.baizhi.entity.Student;
import com.baizhi.entity.Tag;
import com.baizhi.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CityService cityService;


    @RequestMapping("download")
    public void download(Integer page, String colName, String colValue, HttpServletRequest request, HttpServletResponse response) throws IOException {
        page = page == null ? 1 : page;
        List<Student> students = studentService.findAll(page, 5, colName, colValue);
        ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = objectMapper.writeValueAsString(students);
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("content-disposition","attachment;fileName=students.json");
        ServletOutputStream os = response.getOutputStream();
        os.write(json.getBytes());
        os.close();
    }

    /**
     * 查询所有学生
     *
     */
    @RequestMapping("findAll")
    public String findAllStudents(Integer page, Integer rows, String colName, String colValue, HttpServletRequest request) {
        page = page == null ? 1 : page;
        rows = rows == null ? 5 : rows;
        List<Student> students = studentService.findAll(page, rows, colName, colValue);
        Long total = studentService.queryTotalCount(colName, colValue);
        long totalPage = total % rows == 0 ? total / rows : total / rows + 1;
        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("total", total);
        request.setAttribute("students", students);
        request.setAttribute("colName", colName);
        request.setAttribute("colValue", colValue);
        return "back/student/index";
    }

    /**
     * 转到添加页面
     *
     */
    @RequestMapping("toAddPage")
    public String toAddPage(HttpServletRequest request) {
        //查询班级和小组
        List<Clazz> clazzAndGroups = clazzService.findClazzAndGroups();
        List<City> citys = cityService.findAll();
        List<Tag> tags = tagService.findByTagType("学生");
        request.setAttribute("clazzAndGroups", clazzAndGroups);
        request.setAttribute("citys", citys);
        request.setAttribute("tags", tags);
        return "back/student/add";
    }


    /**
     * 添加学生信息
     */
    @RequestMapping("save")
    public String saveStudent(Student student, String clazzGroupId, String[] tagIds) {
        //strings
        List<String> strings = Arrays.asList(tagIds);
        studentService.save(student, clazzGroupId, strings);
        return "redirect:/student/findAll";
    }


    /**
     * 根据学生id查询学生信息
     */
    @RequestMapping("findOne")
    public String findOneStudent(String studentId, HttpServletRequest request) {
        //查询学生
        Student student = studentService.findOneStudentById(studentId);
        //查询班级分组
        List<Clazz> clazzAndGroups = clazzService.findClazzAndGroups();
        //查询标签
        List<Tag> tags = tagService.findByTagType("学生");
        //查询城市
        List<City> cities = cityService.findAll();
        request.setAttribute("student", student);
        request.setAttribute("clazzAndGroups", clazzAndGroups);
        request.setAttribute("citys", cities);
        request.setAttribute("tags", tags);
        return "back/student/update";
    }

    /**
     * 更新学生信息
     *
     * @return
     */
    @RequestMapping("update")
    public String updateStudent(Student student, String clazzGroupId, String[] tagIds) {
        //标签列表
        List<String> strings = Arrays.asList(tagIds);
        studentService.update(student, clazzGroupId, strings);
        return "redirect:/student/findAll";
    }

}

