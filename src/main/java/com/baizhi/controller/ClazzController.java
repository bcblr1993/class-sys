package com.baizhi.controller;

import com.baizhi.entity.Clazz;
import com.baizhi.service.ClazzService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/clazz")
public class ClazzController {


    @Autowired
    private ClazzService clazzService;

    @Value("${dir}")
    private String realpath;

    /**
     * 查询所有班级
     */
    @RequestMapping("findAll")
    public String findAllClazzs(HttpServletRequest request) {
        List<Clazz> clazzs = clazzService.findAll();
        request.setAttribute("clazzs", clazzs);
        return "/back/clazz/index";
    }

    /**
     * 查询所有班级
     */
    @RequestMapping("findAllClazzsForGroups")
	public String findAllClazzsForGroups(HttpServletRequest request){
		List<Clazz> clazzs = clazzService.findAll();
		request.setAttribute("clazzs",clazzs);
		return "/back/group/add";
	}

    /**
     * 保存班级
     */
    @RequestMapping("save")
    public String saveClazz(Clazz clazz, MultipartFile photo,HttpServletRequest request) {
        try {
            String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
            String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"."+extension;
            photo.transferTo(new File(realpath,newFileName));
            clazz.setPath("/"+newFileName);
            clazzService.save(clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/clazz/findAll";
    }

    /**
     * 查询所有班级和组
     *
     * @return
     */
//    public String findAllClazzAndGroups() {
//        clazzs = clazzService.findClazzAndGroups();
//        return Action.NONE;
//    }
}
