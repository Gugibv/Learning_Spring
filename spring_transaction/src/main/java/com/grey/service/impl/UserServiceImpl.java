package com.grey.service.impl;

import com.grey.dao.IUserDao;
import com.grey.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    private  IUserDao userDao;


    @Autowired
    public void setUserDao(IUserDao userDao){
        this.userDao = userDao;
    }


    @Transactional
    @Override
    public void trans() {
        sub();  // 张三扣钱
        add(); // 李四加钱
    }

    @Override
    public void sub() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        System.out.println("张三扣钱");
        userDao.sub();
    }


    @Override
    public void add(){
        System.out.println("李四加钱");

        int i=1/0;

        userDao.save();
    }





}
