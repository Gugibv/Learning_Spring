package com.grey.tests;

import com.grey.IoCJavaConfig;
import com.grey.beans.Person;
import com.grey.beans.Role;
import com.grey.beans.User;
import com.grey.beans.Wife;
import com.grey.controller.UserController;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;


@SpringBootTest
public class JavaConfigTest {
    AnnotationConfigApplicationContext ioc;

    @Before
    public void before(){

        ioc=new AnnotationConfigApplicationContext(IoCJavaConfig.class);

    }

    @Test
    public  void getController(){
        UserController userController = ioc.getBean(UserController.class);
        assertNotNull(userController);
        userController.getUser();
    }


    @Test
    public  void getThirdPartyBean(){
        DruidDataSource datasource = (DruidDataSource) ioc.getBean("dd");
        System.out.println(datasource);
        assertNotNull(datasource);
        try (datasource; Connection connection = datasource.getConnection()) {
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            System.err.println("数据库连接失败：" + e.getMessage());
        }

    }


    /**
     *  @Import(MyImportBeanDefinitionRegistrar.class)
     */
    @Test
    public  void importRegistrarExample(){
        Person person = ioc.getBean(Person.class);
        assertNotNull(person);
        System.out.println(person.getName());
    }



    /**
     *  @Import(MyImportSelector.class)
     */
    @Test
    public  void importSelectorExample(){
        Wife wife = ioc.getBean(Wife.class);
        assertNotNull(wife);
        System.out.println(wife.getName());
    }

    /**
     *  @Import(MyImportSelector.class)
     */
    @Test
    public  void importSecondConfigExample(){
        User user = ioc.getBean("userSpecial",User.class);
        assertNotNull(user);
        System.out.println(user.getName());
    }

}
