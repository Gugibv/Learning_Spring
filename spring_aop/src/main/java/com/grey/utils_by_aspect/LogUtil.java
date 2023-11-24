package com.grey.utils_by_aspect;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LogUtil {

    @Before("execution(* com.grey.service..*.*(..))")
    public static void before(){
        System.out.println("LogUtil.before() 被调用，输出： 方法前");
    }

    @After("execution(* com.grey.service..*.*(..))")
    public static void after(){
        System.out.println("LogUtil.after() 被调用，输出： 方法后");
    }


    @AfterThrowing("execution(* com.grey.service..*.*(..))")
    public static void afterException(){
        System.out.println("LogUtil.afterException() 被调用，输出：方法异常");
    }


    @AfterReturning("execution(* com.grey.service..*.*(..))")
    public static void afterEnd(){
        System.out.println("LogUtil.afterEnd() 被调用，输出：方法返回");

    }
}
