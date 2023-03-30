package cn.grey.service.impl;

import cn.grey.dao.UserDao;
import cn.grey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    //userServiceImpl
//@Primary    //设置自动注入的主要Bean
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    public void getBean() {
        System.out.println("UserServiceImpl");
        userDao.getUser();
    }
}
