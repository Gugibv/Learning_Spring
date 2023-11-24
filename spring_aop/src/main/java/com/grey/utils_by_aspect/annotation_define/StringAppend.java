package com.grey.utils_by_aspect.annotation_define;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 字符串拼接 自定义注解类
 */
@Target(ElementType.METHOD)   // 表示该自定义注解可以应用于方法上
@Retention(RetentionPolicy.RUNTIME)  // 表示该自定义注解在运行时可见，可以通过反射获取到注解信息
public @interface StringAppend {
    String word() default "，我是默认的被额外拼接的字符串";
}

