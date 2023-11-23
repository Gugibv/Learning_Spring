package com.grey.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/*
 * 这是一个实现了Java的InvocationHandler接口的类，通常用于Java动态代理机制。
 * 动态代理是一种在运行时创建代理类和对象的机制，它可以在不预先知道被代理类的情况下，通过反射机制动态创建代理类和对象。
 */
public class MyInvocationHandler implements InvocationHandler {


    Object target;// 被代理的对象
    public MyInvocationHandler(Object target) {
        this.target=target;
    }


    /**
     * InvocationHandler接口中的方法，也是动态代理的关键
     *
     * 这个实现并没有对方法进行额外的处理，它只是透明地将调用委托给了被代理的对象。
     *
     * 这个类的实例通常会作为参数传递给 Proxy.newProxyInstance方法，用于创建代理对象。
     *
     * 代理对象会在调用方法时执行 invoke 方法，允许在调用前后插入其他逻辑，实现一些额外的功能，比如日志、性能监控等。
     */
    // 代理类的执行方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result=null;
        try {
            CalculatorLogUtil.before(method,args);
            result = method.invoke(target, args);
            CalculatorLogUtil.after(method,args);
        }
        catch (Exception ex){

            CalculatorLogUtil.afterException(ex);
        }
        finally {
            CalculatorLogUtil.afterEnd(result);
        }

        return result;
    }


}
