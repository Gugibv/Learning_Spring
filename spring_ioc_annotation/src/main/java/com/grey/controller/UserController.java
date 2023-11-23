package com.grey.controller;

import com.grey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
@Lazy
public class UserController {


    /**
     * @Autowired和@Resource区别
     *
     * @Resource 优先根据名字匹配，依赖jdk
     *
     * @Autowired 优先根据类型匹配，依赖spring
     *
     * 此处相当于 ：  @Qualifier("userServiceImpl")
     *              @Resource
     */
    @Autowired
    UserService userService;


    /**
     @Autowired 也可以写在构造器上面 ,默认优先根据参数类型去匹配 ,如果匹配到多个类型则会按照参数名字匹配
     例如：

      @Autowired
      public UserController(UserService userService) {
         this.userService = userService;
      }


     @Autowired 也可以写在方法上面  ,默认优先根据参数类型去匹配 ,如果匹配到多个类型则会按照参数名字匹配
     例如：

     @Autowired
      public void createUserSerive(@Qualifier("userServiceImpl")UserService userService){
         this.userService=userService;
     }

     */




    public void getUser(){
        userService.getBean();
    }
}
