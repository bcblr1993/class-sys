package com.baizhi.controller;

import com.baizhi.entity.City;
import com.baizhi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/city")
public class CityController {


	@Autowired
	private CityService cityService;

	/**
	 * 查询城市方法
	 */
	@RequestMapping("findAll")
	public String findAllCitys(HttpServletRequest request){
		List<City> cities = cityService.findAll();
		request.setAttribute("cities",cities);
		return "back/city/index";
	}
	
	/**
	 * 保存城市的方法
	 */
	@RequestMapping("save")
	public String saveCity(City city){
		cityService.save(city);
		return "redirect:/city/findAll";
	}


	/**
	 * 删除城市
	 */
	@RequestMapping("/delete")
	public String deleteCity(Integer id){
		cityService.delete(id);
		return "redirect:/city/findAll";
	}
	
	
	
}
