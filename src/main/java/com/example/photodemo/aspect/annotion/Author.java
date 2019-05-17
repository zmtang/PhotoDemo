package com.example.photodemo.aspect.annotion;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author zmt
 * @date 2019-05-09 11:48
 */
@Documented
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
        String name() default "zmt";
        int age() default 28;
        String job() default  "java";
}
