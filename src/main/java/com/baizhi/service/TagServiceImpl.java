package com.baizhi.service;

import com.baizhi.dao.TagDAO;
import com.baizhi.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDAO tagDAO;

    public void save(Tag tag) {
        tag.setCreateDate(new Date());//生成创建时间
        tagDAO.save(tag);//保存tag
    }

    public List<Tag> findAll() {
        return tagDAO.queryAll();
    }


    public List<Tag> findByTagType(String type) {
        return tagDAO.queryByTagType(type);
    }


    @Override
    public void delete(int id) {
        tagDAO.delete(id);
    }
}
