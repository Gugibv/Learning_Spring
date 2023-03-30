package cn.grey.tests;

import cn.grey.IoCJavaConfig;
import cn.grey.beans.Person;
import cn.grey.beans.Role;
import cn.grey.beans.User;
import cn.grey.controller.UserController;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigTest {
    AnnotationConfigApplicationContext ioc;

    @Before
    public void before(){
        ioc=new AnnotationConfigApplicationContext(IoCJavaConfig.class);
    }

    @Test
    public  void test01(){
        UserController bean = ioc.getBean(UserController.class);
        bean.getUser();

    }


    @Test
    public  void test02(){
        DruidDataSource bean = (DruidDataSource) ioc.getBean("dataSource");
        System.out.println(bean);

    }

    @Test
    public  void test03(){
        User bean = (User) ioc.getBean("user2");
        System.out.println(bean);

    }

    @Test
    public  void test04(){
        Role bean =   ioc.getBean(Role.class);
        System.out.println(bean);

    }


    /**
     * @Import(MyImportSelector.class)
     */
    @Test
    public  void test05(){
        Person bean = ioc.getBean(Person.class);
        System.out.println(bean.getName());
    }

    /**
     * @Import(MyImportBeanDefinitionRegistrar.class)
     */
    @Test
    public  void test06(){
        Person bean = ioc.getBean(Person.class);
        System.out.println(bean.getName());
    }
}
