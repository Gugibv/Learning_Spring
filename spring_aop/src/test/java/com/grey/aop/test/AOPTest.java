package com.grey.aop.test;

import com.grey.controller.UserController;
import com.grey.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class AOPTest {



    ClassPathXmlApplicationContext ioc;

    @Before
    public void before() {
        ioc = new ClassPathXmlApplicationContext("classpath:/spring_aop.xml");
    }

    @Test
    public void callUserController() {
        UserController userController = ioc.getBean(UserController.class);
        assertNotNull(userController);
        userController.get(1);
    }
}
