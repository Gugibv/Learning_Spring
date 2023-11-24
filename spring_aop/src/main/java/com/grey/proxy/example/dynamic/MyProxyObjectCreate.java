package com.grey.proxy.example.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyProxyObjectCreate {


    /**
     * 该类只包含了静态方法，而默认的公共构造函数是由Java隐式提供的；
     * 此处通过添加私有构造函数，防止使用默认的公共构造函数创建类的实例，导致工具类被意外实例化，或内存资源浪费。
     */
    private MyProxyObjectCreate(){}



    /**
     * 公共jdk动态代理对象生成
     */
    public static Object createProxy(Object needProxy){

        ClassLoader classLoader = needProxy.getClass().getClassLoader();  // 获取被代理对象的类加载器
        Class<?>[] interfaces= needProxy.getClass().getInterfaces();  // 获取被代理对象实现的接口
        InvocationHandler handler=new MyInvocationHandler(needProxy); //  创建一个实现了 InvocationHandler 接口的对象, 传入被代理的对象


        Object object = Proxy.newProxyInstance(classLoader, interfaces, handler);  // 动态创建代理类

        System.out.println("代理类被创建成功 ： "+ object.getClass());

        return object;
    }
}
