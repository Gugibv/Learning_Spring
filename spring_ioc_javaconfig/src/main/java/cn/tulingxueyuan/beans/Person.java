package cn.tulingxueyuan.beans;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    @Value("徐庶")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
