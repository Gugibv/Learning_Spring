package com.grey.streamCorruptedException.test;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;
    public User(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String GetName(){
        return this.name;
    }
    public int GetAge(){
        return this.age;
    }
}
