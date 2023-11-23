package com.grey.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@DependsOn("user")
@Lazy
@Scope("prototype")
public class Role {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role() {

        System.out.println("我是 Role Bean 的无参构造方法，我被加载 ");

    }

}
