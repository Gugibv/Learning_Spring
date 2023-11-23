package com.grey.proxy.dynamic;


import java.lang.reflect.Method;
import java.util.Arrays;

public class CalculatorLogUtil {

    private CalculatorLogUtil(){}


    public static void before(Method method, Object[] args){
        System.out.println(method.getName()+" 方法前,参数为："+ Arrays.toString(args));
    }

    public static void after(Method method, Object[] args){
        System.out.println(method.getName()+" 方法后,参数为："+ Arrays.toString(args));
    }


    public static void afterException(Exception ex){

        System.out.println("方法异常:" + ex.getCause());
        ex.printStackTrace();
    }

    public static void afterEnd(Object result){
        System.out.println("方法结束，返回值是:"+result);


    }
}
