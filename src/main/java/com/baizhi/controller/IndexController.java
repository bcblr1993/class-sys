package com.baizhi.controller;

import com.baizhi.entity.Clazz;
import com.baizhi.entity.Student;
import com.baizhi.entity.Tag;
import com.baizhi.service.ClazzService;
import com.baizhi.service.StudentService;
import com.baizhi.service.TagService;
import com.baizhi.vos.TagTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenyn
 * @since 1.0
 */
@Controller
public class IndexController {


    //设置欢迎页面
    @RequestMapping("/")
    public String login(){
        return "redirect:/back/login.jsp";
    }


    @Autowired
    private ClazzService clazzService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TagService tagService;

    //统计标签类型
    @RequestMapping("/getTag")
    @ResponseBody
    public List<TagTypeVO> getTag(){
        List<Tag> clazzTags = tagService.findByTagType("班级");
        List<Tag> studentTag = tagService.findByTagType("学生");
        List<TagTypeVO> tagTypeVOS = new ArrayList<>();
        tagTypeVOS.add(new TagTypeVO(clazzTags.size(),"班级标签"));
        tagTypeVOS.add(new TagTypeVO(studentTag.size(),"学生标签"));
        return tagTypeVOS;
    }

    //统计班级和学生
    @RequestMapping("/getClazz")
    @ResponseBody
    public Map<String, List<?>> getClazz(){
        HashMap<String, List<?>> result = new HashMap<>();
        List<String> clazzNames = clazzService.findAll().stream().map(Clazz::getName).collect(Collectors.toList());
        List<Integer> clazzCounts = new ArrayList<>();
        List<Student> students = studentService.findAll(1, Integer.MAX_VALUE, null, null);
        clazzNames.forEach(clazzName->{
            int size = students.stream().filter(student -> student.getClazz().getName().equals(clazzName)).map(Student::getName).collect(Collectors.toList()).size();
            clazzCounts.add(size);
        });
        result.put("categories",clazzNames);
        result.put("data",clazzCounts);
        return result;
    }
}

