package com.grey.utils_by_aspect;

import com.grey.utils_by_aspect.annotation_define.StringAppend;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class LogUtilByPointcut {

    /**
     * 声明切点,让其他通知引用，更具有重用性
     */
    @Pointcut("execution(* com.grey.service.impl.*.*(..))")
    public void pointcut(){}


    @Before("pointcut() && @annotation(stringAppend)")
    public void before(JoinPoint joinPoint, StringAppend stringAppend){
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 所有的参数
        Object[] args = joinPoint.getArgs();

        System.out.println(methodName+"方法运行,参数是："+ Arrays.asList(args)+"注解的值是：" + stringAppend.word());
    }


}
