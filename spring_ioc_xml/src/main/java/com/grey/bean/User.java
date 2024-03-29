package com.grey.bean;


public class User {
    private Integer id;
    private String username;
    private String realname;

    public Integer getId() {
        return id;
    }

    // 基于setter方法的依赖注入，在xml 文件中配置的 property 属性匹配的是对应的set方法的名字
    // 比如 setId，那么匹配的是 name="id"，又比如 setXxx 那么匹配的是 name="xxx"
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public User() {
        System.out.println("我是User Bean,  在容器实例化的时候，就会加载我");
    }

    public User(Integer id, String username, String realname) {
        this.id = id;
        this.username = username;
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}
