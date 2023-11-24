package com.grey.utils_by_aspect.annotation_define;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StringAppend {
    String word() default "，我是默认的被额外拼接的字符串";
}

