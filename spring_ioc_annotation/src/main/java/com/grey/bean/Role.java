package com.grey.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@DependsOn("user")
@Lazy
@Scope("prototype")
@PropertySource("classpath:application.properties")
public class Role {

    @Value("${role.property.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role() {

        System.out.println("我是 Role Bean 的【无参构造函数】，我在bean 被创建时调用了");

    }


    /**
     * 当 Spring 容器创建 Role Bean 时，会首先调用构造函数，然后再调用 init 方法。因此，init 方法可以用于执行一些初始化逻辑。
     */
    @PostConstruct
    public void init(){

        System.out.println("我是 Role Bean 的【 @PostConstruct 】注解下】的初始化方法，我被调用了");

    }


    @PreDestroy
    public  void destory(){

        System.out.println("我是 Role Bean 的【 @PreDestroy 】注解下的销毁方法，我被调用 ！ ");

    }
}
