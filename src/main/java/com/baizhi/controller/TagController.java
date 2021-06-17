package com.baizhi.controller;

import com.baizhi.entity.Tag;
import com.baizhi.service.TagService;
import com.baizhi.service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("tag")
public class TagController{


	@Autowired
	private TagService tagService = new TagServiceImpl();


	/**
	 * 查询所有标签
	 */
	@RequestMapping("findAll")
	public String findAll(HttpServletRequest request){
		List<Tag> list = tagService.findAll();
		request.setAttribute("tags",list);
		return "back/tag/index";
	}
	
	/**
	 * 保存标签
	 */
	@RequestMapping("save")
	public String saveTag(Tag tag){
		tagService.save(tag);
		return "redirect:/tag/findAll";
	}
	/**
	 * 根据类型查询班级
	 */
	@RequestMapping("findByTagType")
	public String findByTagType(String type, HttpServletRequest request){
		List<Tag> list = tagService.findByTagType(type);
		request.setAttribute("tags",list);
		if("班级".equals(type)){
			return "back/clazz/add";
		}
		return "back/student/add";
	}


	/**
	 * 删除标签
	 */
	@RequestMapping("delete")
	public String delete(int id){
		tagService.delete(id);
		return "redirect:/tag/findAll";
	}


}
