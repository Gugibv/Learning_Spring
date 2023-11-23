package com.grey.dao.impl;


import com.grey.dao.UserDao;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public class UserDaoImpl implements UserDao {

    public void getUser() {

        System.out.println("查询数据库");

    }
}
