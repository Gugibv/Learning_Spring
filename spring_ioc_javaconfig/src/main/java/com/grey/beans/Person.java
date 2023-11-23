package com.grey.beans;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    @Value("阿尔萨斯")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
