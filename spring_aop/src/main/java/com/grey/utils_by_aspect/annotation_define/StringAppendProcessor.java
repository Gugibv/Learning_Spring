package com.grey.utils_by_aspect.annotation_define;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StringAppendProcessor {


    /**
     * 该方法的主要逻辑是在目标方法执行后，将目标方法的返回值与 StringAppend 注解中指定的字符串进行拼接，并返回最终的字符串结果
     * @param joinPoint  代表被切入的方法，可以通过它获取到方法的信息
     * @param append  代表使用了 StringAppend 注解，并且注解中指定了属性值的对象
     *
     */
    @Around("@annotation(append)")
    public String process(ProceedingJoinPoint joinPoint, StringAppend append) throws Throwable{
        return joinPoint.proceed() + " " + append.word();
    }

}
