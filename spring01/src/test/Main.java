package test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;
import service.IUserService;
import service.impl.UserServiceImpl;

public class Main {

      public static void main(String[]args){

            ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
            IUserService service = ioc.getBean(IUserService.class);
            User user =service.getUsers();
            System.out.println(user.getUsername());

            // Exception in thread "main" java.lang.NoClassDefFoundError: org/apache/commons/logging/LogFactory
            // 解决：spring5.0 后引入 spring-jcl-5.3.25-SNAPSHOT 包
      }

}