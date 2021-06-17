package com.baizhi.controller;

import com.baizhi.entity.Group;
import com.baizhi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("group")
public class GroupController{


	@Autowired
	private GroupService groupService ;

	/**
	 * 查询所有小组
	 * @return
	 */
	@RequestMapping("findAll")
	public String findAllGroups(HttpServletRequest request){
		List<Group> groups = groupService.findAll();
		request.setAttribute("groups",groups);
		return "back/group/index";
	}
	
	/**
	 * 添加小组
	 */
	@RequestMapping("save")
	public String  saveGroup(Group group){
		groupService.save(group);
		return "redirect:/group/findAll";
	}
	
	
	
	
	
	
}
