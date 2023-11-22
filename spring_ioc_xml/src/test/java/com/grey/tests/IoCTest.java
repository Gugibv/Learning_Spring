package com.grey.tests;

import com.grey.bean.Person;
import com.grey.bean.User;
import com.grey.bean.Wife;
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

    /**
     *  bean 实例化的第一种方法 ： 使用构造器实例化Bean，这是默认 , 无法干预实例化过程
     */
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

    /**
     *  bean 实例化的第二种方法 ： 使用静态工厂方法实例化Bean
     */
    @Test
    public void instantiateBeanByStaticFactory(){
        User bean =  ioc.getBean("user08",User.class);
        assertNotNull(bean);
        System.out.println(bean);
    }

    /**
     *  bean 实例化的第三种方法 ： 使用工厂方法实例化Bean
     */
    @Test
    public void instantiateBeanByBeanFactory(){
        User bean =  ioc.getBean("user09",User.class);
        assertNotNull(bean);
        System.out.println(bean);
    }

    /**
     *  bean 实例化的第四种方法 ： 通过`FactoryBean`接口实例化
     */
    @Test
    public void instantiateBeanByBeanFactoryInterface(){
        User bean =  ioc.getBean("user10",User.class);
        assertNotNull(bean);
        System.out.println(bean);
    }

    /**
     * bean 的依赖和配置
     */
    @Test
    public void beanDependencyInjection(){
        Person bean =  ioc.getBean("person01",Person.class);
        assertNotNull(bean);
        System.out.println(bean);

        Wife wife01 =  ioc.getBean("wife01",Wife.class);
        Wife wife02 =  ioc.getBean("wife02",Wife.class);


        System.out.println(wife01);
        System.out.println(wife02);

    }

    /**
     * bean 自动注入方式之一：byName
     */
    @Test
    public void beanInjectionByName(){
        Person bean =  ioc.getBean("person02",Person.class);
        assertNotNull(bean);
        System.out.println(bean);
    }



    /**
     * bean 自动注入方式之二：byType
     */
    @Test
    public void beanInjectionByType(){
        Person bean =  ioc.getBean("person03",Person.class);
        assertNotNull(bean);
        System.out.println(bean);
    }


    /**
     * bean 自动注入方式之三：constructor
     */
    @Test
    public void beanInjectionByConstructor(){
        Person bean =  ioc.getBean("person04",Person.class);
        assertNotNull(bean);
        System.out.println(bean);
    }


    /**
     *  作用域
     */
    @Test
    public void scopeTest() {
        Person person1 = ioc.getBean("person05", Person.class); //new Person()
        Person person2 = ioc.getBean("person05", Person.class); //new Person()
        Person person3 = ioc.getBean("person05", Person.class); //new Person()

        // scope="singleton" 不管使用多少次，就只会加载一次 person , 此为默认
        // scope="prototype" 则会多长创建加载bean
        assertNotNull(person1);
        assertNotNull(person2);
        assertNotNull(person3);
    }

}
