package com.baizhi.service;

import com.baizhi.dao.CityDAO;
import com.baizhi.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;



    public void save(City city) {
        cityDAO.save(city);

    }

    public List<City> findAll() {
       return cityDAO.queryAll();
    }

    @Override
    public void delete(int id) {
        cityDAO.delete(id);
    }


}
