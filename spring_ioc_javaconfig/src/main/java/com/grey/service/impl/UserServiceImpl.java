package com.grey.service.impl;

import com.grey.dao.UserDao;
import com.grey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    //userServiceImpl
//@Primary    //设置自动注入的主要Bean
public class UserServiceImpl implements UserService{

    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getBean() {
        System.out.println("UserServiceImpl");
        userDao.getUser();
    }
}
