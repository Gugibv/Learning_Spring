package com.grey.closeIOC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("services.xml");
        ioc.registerShutdownHook();
        ioc.start();
    }
}
