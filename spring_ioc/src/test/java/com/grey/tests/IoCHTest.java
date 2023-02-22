package com.grey.tests;

import com.alibaba.druid.pool.DruidDataSource;
import com.grey.bean.Person;
import com.grey.bean.Wife;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCHTest {

    ClassPathXmlApplicationContext ioc;
    @Before
    public void before(){
        // 加载spring容器
        // 在容器实例化的时候 就会加载所有的bean，同时调用bean的所有无参构造函数
        ioc=new ClassPathXmlApplicationContext("spring-ioc-high.xml");
    }

    @Test
    public  void test01() {
        // 这个案例中，bean都是在这句话输出之前加载
        System.out.println("Spring已加载");
    }

    /**
     * 懒加载
     */
    @Test
    public  void test02() {
        // id = "test02" , 因为配置了 lazy-init="true" 懒加载，所以在调用的时候才加载 ，不使用则永远都不会加载
        System.out.println("Spring已加载");
        Wife wife = ioc.getBean("test02", Wife.class);
        System.out.println(wife);

    }
    /**
     * 作用域
     */
    @Test
    public  void test03() {
        Person person1 = ioc.getBean("test03", Person.class); //new Person()
        Person person2 = ioc.getBean("test03", Person.class); //new Person()
        Person person3 = ioc.getBean("test03", Person.class); //new Person()
        Person person4 = ioc.getBean("test03", Person.class); //new Person()
        Person person5 = ioc.getBean("test03", Person.class); //new Person()
        Person person6 = ioc.getBean("test03", Person.class); //new Person()
        // 不管使用多少次，就只会加载一次person
        System.out.println(person1);
    }

    /**
     *  使用静态工厂方法实例化
     */
    @Test
    public  void test04() {
        Person person = ioc.getBean("test04", Person.class);
        System.out.println(person);

    }

    /**
     *  使用实例工厂方法实例化
     */
    @Test
    public  void test05() {
        Person person = ioc.getBean("test05", Person.class);
        System.out.println(person);

    }


    /**
     *  自动注入
     */
    @Test
    public  void test06() {
        Person person = ioc.getBean("person", Person.class);
        System.out.println(person);

    }

    /**
     *  生命周期回调
     *  1. 使用接口的方式实现：
     *      1.初始化回调   实现InitializingBean   重写afterPropertiesSet
     *      2.销毁回调     实现DisposableBean   重写destroy
     *  2. 基于配置的方式实现
     */
    @Test
    public  void test07() {
        Person person = ioc.getBean("person", Person.class);
        System.out.println(person);
        ioc.close();
    }

    /**
     * 引用第三方bean  和 引用外部属性资源文件
     */
    @Test
    public  void test08() {
        DruidDataSource datasource = ioc.getBean("dataSource", DruidDataSource.class);
        System.out.println(datasource);
        ioc.close();
    }


    /**
     * SpEL
     */
    @Test
    public  void test09() {
        Person person = ioc.getBean("person", Person.class);
        System.out.println(person);
    }
}
