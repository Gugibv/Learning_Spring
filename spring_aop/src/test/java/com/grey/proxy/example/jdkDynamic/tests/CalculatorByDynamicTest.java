package com.grey.proxy.example.jdkDynamic.tests;


import com.grey.proxy.example.dynamic.Calculator;
import com.grey.proxy.example.dynamic.ICalculator;
import com.grey.proxy.example.dynamic.MyProxyObjectCreate;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/***
 * 使用jdk动态代理完成增加日志功能:动态生成代理类
 */
public class CalculatorByDynamicTest {

    @Test
    public void testCalculatorDiv() {

        ICalculator proxy = (ICalculator) MyProxyObjectCreate.createProxy(new Calculator());
        assertNotNull(proxy);
        System.out.println(proxy.div(10, 0));
    }
}
