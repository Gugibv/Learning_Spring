package com.grey.utils_by_aspect;

import com.grey.utils_by_aspect.annotation_define.StringAppend;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
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

        System.out.println("LogUtilByPointcut.before()方法被调用，输出："+methodName+"方法运行,参数是："+ Arrays.asList(args)+"注解的值是：" + stringAppend.word());
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint){

        String methodName = joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();
        System.out.println("LogUtilByPointcut.after()方法被调用，输出："+methodName+"方法运行,参数是："+ Arrays.asList(args));
    }

    @AfterThrowing(value="pointcut()", throwing="ex")
    public void afterThrowing(Exception ex){
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw, true));
        System.out.println("LogUtilByPointcut.afterThrowing()方法被调用，输出：后置异常通知"+sw.getBuffer().toString());
    }

    @AfterReturning(value="pointcut()", returning = "returnValue")
    public void afterReturning(Object returnValue){
        System.out.println("LogUtilByPointcut.afterReturning()方法被调用，输出：返回值："+returnValue);
    }

    @Around("pointcut()")
    public  Object arround(ProceedingJoinPoint joinPoint){

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        Object returnValue="";
        try {
            System.out.println("LogUtilByPointcut.arround()方法被调用，环绕：前置通知："+methodName+"方法执行，参数："+Arrays.asList(args));
            returnValue=joinPoint.proceed();
            System.out.println("LogUtilByPointcut.arround()方法被调用，环绕：后置通知："+methodName+"方法执行，参数："+Arrays.asList(args));
        } catch (Throwable throwable) {
            System.out.println("LogUtilByPointcut.arround()方法被调用，环绕：异常通知："+throwable);
        }
        finally {
            System.out.println("LogUtilByPointcut.arround()方法被调用，环绕：返回通知："+returnValue);
        }

        return returnValue;
    }


}
