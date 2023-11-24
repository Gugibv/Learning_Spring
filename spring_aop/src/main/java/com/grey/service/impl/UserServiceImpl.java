package com.grey.service.impl;

import com.grey.bean.User;
import com.grey.dao.UserDao;
import com.grey.service.UserService;
import com.grey.utils_by_aspect.annotation_define.StringAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;



    @Override
    public User get(Integer id) {
        return  userDao.get(id);
    }

    @StringAppend(word = "获取用户名")
    @Override
    public String getName(Integer id) {
        return userDao.get(id).getName();
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
