package com.grey.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class Person implements InitializingBean,DisposableBean {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private List<String> hobbies;
    private Map<Integer,String> course;
    private Wife wife;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<Integer, String> getCourse() {
        return course;
    }

    public void setCourse(Map<Integer, String> course) {
        this.course = course;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", hobbies=" + hobbies +
                ", course=" + course +
                ", wife=" + wife +
                '}';
    }

    public Person() {

        System.out.println("我是persons bean 的无参构造方法，我被spring加载了");

    }


    // 实例化
    public void afterPropertiesSet() {
        System.out.println("我是Person Bean，实现了 InitializingBean 接口，正在调用 afterPropertiesSet() 初始化方法");
    }


    // 销毁
    public void destroy() {
        System.out.println("我是Person Bean，实现了 DisposableBean 接口，正在调用 destroy() 销毁方法");
    }

}
