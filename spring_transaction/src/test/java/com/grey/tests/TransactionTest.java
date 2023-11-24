package com.grey.tests;


import com.grey.service.IUserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TransactionTest {
    ClassPathXmlApplicationContext ioc;
    @Before
    public  void before(){
        ioc=new ClassPathXmlApplicationContext("classpath:spring.xml");
    }


    @Test
    public void test01() {
        IUserService service = ioc.getBean(IUserService.class);
        Assert.assertNotNull(service );
        service.trans();
    }

}
