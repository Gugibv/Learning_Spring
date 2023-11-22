package com.grey.aware.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * 作用： 实现了 ApplicationContextAware 接口的 bean 可以获得对应的应用程序上下文（ApplicationContext）的引用。
 * 使用场景： 当需要在 bean 中获取 Spring 应用程序上下文的引用时，可以实现 ApplicationContextAware 接口。
 */
public class ApplicationContextAwareExample implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    // 可以在这里使用 applicationContext 进行一些操作
}
