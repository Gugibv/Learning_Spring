package com.grey.service.impl;


import com.grey.dao.UserDao;
import com.grey.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl  implements RoleService {
    @Autowired
    UserDao userDao;

    public void getBean() {
        System.out.println("RoleServiceImpl");
        userDao.getUser();
    }
}
