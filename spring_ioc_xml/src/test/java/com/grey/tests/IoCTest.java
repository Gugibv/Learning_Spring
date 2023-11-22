package com.grey.tests;

import com.grey.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;



public class IoCTest {

    ApplicationContext ioc;

    @Before
    public void before(){
        ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");
    }


    @Test
    public void getBeanByName(){
        User bean =  ioc.getBean("user02",User.class);
        assertNotNull(bean);
        System.out.println(bean);
    }


    @Test
    public void getBeanByAlias(){
        User bean =  ioc.getBean("user05",User.class);
        assertNotNull(bean);
        System.out.println(bean);
    }

    @Test
    public void instantiateBeanBySetter(){
        User bean =  ioc.getBean("user06",User.class);
        assertNotNull(bean);
        System.out.println(bean);
    }

    @Test
    public void instantiateBeanByConstructor(){
        User bean =  ioc.getBean("user07",User.class);
        assertNotNull(bean);
        System.out.println(bean);
    }



}
