package com.grey.bean;

import java.util.Date;


public class PersonFacotry {
    public Person createPersonFacotryMethod() {
        Child child = new Child();
        child.setName("儿子");
        return child;
    }

    public static Date getNowDate() {
        return new Date();
    }
}
