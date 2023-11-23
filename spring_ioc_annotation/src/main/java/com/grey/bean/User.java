package com.grey.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class User {


    @Value("#{role.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
        System.out.println("User已加载");
    }

    private void initByConfig() {
        System.out.println("User初始化");
    }

    private void destroyByConfig() {
        System.out.println("User销毁");
    }
}
