package com.grey.tests;


import com.grey.bean.Role;
import com.grey.bean.User;
import com.grey.controller.UserController;
import com.grey.service.RoleService;
import com.grey.service.UserService;
import com.grey.service.impl.RoleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class IocTest {
    ClassPathXmlApplicationContext ioc;

    @Before
    public void before() {

        ioc = new ClassPathXmlApplicationContext("spring_ioc.xml");

    }

    @Test
    public void getController() {
        UserController userController = (UserController) ioc.getBean("userController");
        assertNotNull(userController);
        System.out.println(userController);
    }

    @Test
    public void getUserBean() {
        User user = ioc.getBean(User.class);
        assertNotNull(user);
        System.out.println(user.getName());
    }

    @Test
    public void getUserFromDatabase() {
        UserController userController = ioc.getBean(UserController.class);
        assertNotNull(userController);
        userController.getUser();

    }

    @Test
    public void getRoleBeanPrototype() {

        Role bean = ioc.getBean(Role.class);
        Role bean2 = ioc.getBean(Role.class);
        Role bean3 = ioc.getBean(Role.class);

        assertNotNull(bean);
        assertNotNull(bean2);
        assertNotNull(bean3);
    }

    @Test
    public void postConstructExample() {
        Role bean = ioc.getBean(Role.class);
        assertNotNull(bean);
        ioc.close();
    }


    @Test
    public void instanceofExample() {

        UserService userService = ioc.getBean(UserService.class);
        RoleServiceImpl roleService=new RoleServiceImpl();

        System.out.println((roleService instanceof RoleService));
        // instanceof  用于判断前面的对象是否是否吗的类，或者子类，或者接口

        assertNotNull(userService);
    }
}
