package com.example.photodemo.aspect;

import com.example.photodemo.entity.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 控制层切面处理类
 *
 * @author zmt
 * @date 2019-03-20 15:53
 */
@Aspect
@Component
public class ControllerValidationAspect {
    /*
    带有@Transactional标注的所有类的任意方法.
    @within(org.springframework.transaction.annotation.Transactional)
    @target(org.springframework.transaction.annotation.Transactional)
            带有@Transactional标注的任意方法.
    @annotation(org.springframework.transaction.annotation.Transactional)
    ***> @within和@target针对类的注解,@annotation是针对方法的注解
    参数带有@Transactional标注的方法.
    @args(org.springframework.transaction.annotation.Transactional)
    参数为String类型(运行是决定)的方法.
    args(String)
    https://blog.csdn.net/qq_18769269/article/details/80841734
    */

    /**
     * Pointcut的定义包括两个部分：Pointcut表示式(expression)和Pointcut签名(signature)
     */
//    @Pointcut("execution(* com.example.photodemo.controller.*(..))")
//    public void validationPointcut(){
//    }
//
//    @Before(value = "validationPointcut()")
//    public void before(){
//        System.out.println("before切口，进入控制层之前");
//    }
//
//    @After("validationPointcut()")
//    public void after(){
//        System.out.println("after切口，进入控制层后");
//    }

   /* @Around("@annotation(per)")
    public void deArround(ProceedingJoinPoint pjp, Person per){
        System.out.println("after切口，进入控制层后");
    }*/
}
