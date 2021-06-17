package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserSerivceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    //注册用户
    public void save(User user) {
        User userDB = userDAO.queryUser(user.getUsername());
        if(userDB!=null) throw new RuntimeException("用户名已存在!");
        user.setCreateDate(new Date());
        userDAO.save(user);

    }

    //用户登陆
    public User login(User user) {
        //根据用户名查询用户
        User userDB = userDAO.queryUser(user.getUsername());
        //判断用户是否存在
        if (userDB != null) {
            //比较密码
            if (userDB.getPassword().equals(user.getPassword())) {
                return userDB;
            } else {
                throw new RuntimeException("密码输入错误~~");
            }
        } else {
            throw new RuntimeException("用户名输入错误~~");
        }
    }

}
