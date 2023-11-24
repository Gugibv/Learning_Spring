package com.grey.controller;

import com.grey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {


    @Autowired
    UserService userService;


    public void get(Integer ID){
        System.out.println("业务请求获得响应结果："+userService.getName(ID));
    }
}