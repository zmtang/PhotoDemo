package com.example.photodemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zmt
 * @date 2019-05-09 09:52
 * / @Component 表示该类的实例会被Spring IOC容器管理
 */
@Component
@Aspect
public class Advices {
    /**
     * execution(* com.tp.soft.service..*.*(..))
     *
     *  整个表达式可以分为五个部分：
     *
     *  1、execution(): 表达式主体。
     *
     *  2、第一个*号：表示返回类型，*号表示所有的类型。
     *
     *  3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
     *
     *  4、第二个*号：表示类名，*号表示所有的类。
     *
     *  5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
     */

    /**
     * 如果要获取拦截方法的所有参数，可以用JoinPoint或ProceedingJoinPoint，两者的区别：
     *      * JoinPoint是父类，提供获取拦截方法的信息的功能，如所有参数：jp.getArgs()
     *      * ProceedingJoinPoint是子类，只能用在@Around中，除了提供JoinPoint的所有功能外，还能提供方法的运行pjp.proceed()和pjp.proceed(args)功能。
     *      pjp.proceed();
     */
    @Before("execution(* com.example.photodemo.controller..*.*(..))")
    public void  before(JoinPoint jp){
        System.err.println(" Advices 前置通知,,,,,");
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        // 获取被包围的方法信息
        Method method = methodSignature.getMethod();
        System.err.println(" Advices 前置通知,,,,,"+method.toString());
        // 通过这获取到方法的所有参数名称的字符串数组
        String[] parameterNames = methodSignature.getParameterNames();

    }


    @After("execution(* com.example.photodemo.controller..*.*(..))")
    public void after(JoinPoint jp){
        System.err.println(" Advices 后置通知......");
    }
}
