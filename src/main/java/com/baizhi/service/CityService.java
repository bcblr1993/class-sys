package com.baizhi.service;

import com.baizhi.entity.City;

import java.util.List;


public interface CityService {

	
	void save(City city);
	
	
	List<City> findAll();


	void delete(int id);
	
}
