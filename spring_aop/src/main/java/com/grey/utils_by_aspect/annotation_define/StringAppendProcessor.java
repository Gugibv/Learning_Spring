package com.grey.utils_by_aspect.annotation_define;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StringAppendProcessor {

    @Around("@annotation(append)")
    public String process(ProceedingJoinPoint joinPoint, StringAppend append) throws Throwable{
        return joinPoint.proceed() + " " + append.word();
    }

}
