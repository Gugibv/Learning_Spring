package com.grey.dao.impl;

import com.grey.bean.User;
import com.grey.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    public User get(Integer id) {
        if(id==null){
            throw new NullPointerException();
        }

        User user = new User();
        user.setName("阿尔萨斯");
        System.out.println("数据库执行SELECT");

        return user;
    }

    public void add(User user) {
        if(user==null){
            throw new NullPointerException();
        }
        System.out.println("数据库执行ADD");
    }

    public void delete(Integer id) {
        if(id==null){
            throw new NullPointerException();
        }
        System.out.println("数据库执行DELETE");
    }

    public void update(User user) {
        if(user==null){
            throw new NullPointerException();
        }
        System.out.println("数据库执行UPDATE");
    }
}
