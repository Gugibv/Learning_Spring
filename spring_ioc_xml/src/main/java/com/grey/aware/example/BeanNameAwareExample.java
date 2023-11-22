package com.grey.aware.example;

import org.springframework.beans.factory.BeanNameAware;

/**
 * 作用： 实现了 BeanNameAware 接口的 bean 可以获取自身在 Spring 容器中的 bean 名称。
 * 使用场景： 当需要在 bean 中获取自身在 Spring 容器中的名字时，可以实现 BeanNameAware 接口。
 */
public class BeanNameAwareExample implements BeanNameAware {
    private String beanName;


    @Override
    public void setBeanName(String name) {
        this.beanName = beanName;
    }

    // 可以在这里使用 beanName 进行一些操作

}
