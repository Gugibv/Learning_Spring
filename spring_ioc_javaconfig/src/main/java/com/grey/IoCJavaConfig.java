package com.grey;

import com.alibaba.druid.pool.DruidDataSource;
import com.grey.beans.MyImportBeanDefinitionRegistrar;
import com.grey.beans.MyImportSelector;
import com.grey.beans.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan(basePackages = "com.grey")
@PropertySource("classpath:db.properties")
@Import({MyImportSelector.class, MyImportBeanDefinitionRegistrar.class , SecondJavaConfig.class})
public class IoCJavaConfig {

    @Value("${mysql.name}")
    private String name;
    @Value("${mysql.password}")
    private String password;
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.driverClassName}")
    private String driverClassName;


    /**
     *  可以将一个类的实例(可以干预Bean实例化过程),注册为一个Bean
     *  会自动将返回值作为Bean的类型    将方法名作为bean的名字
     *
     *  自动依赖外部 Bean 的例子 ：
     */
    @Bean(name = {"dataSource","dd"})
    @Scope("prototype")
    public DruidDataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();

        dataSource.setUsername(name);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }


    @Bean
    public User user(){
        return new User();
    }

}
