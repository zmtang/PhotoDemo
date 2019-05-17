package com.example.photodemo.aspect;

import com.example.photodemo.aspect.annotion.Author;
import com.example.photodemo.util.SpelParser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 自定义注解的切口实现
 * 自定义接口核心 反射机制
 * @author zmt
 * @date 2019-05-09 12:05
 */
@Component
@Aspect
public class AuthorAdvice {

    /**
     *  该JoinPoint参数就代表了织入增强处理的连接点。JoinPoint里包含了如下几个常用的方法：
     *
     * Object[] getArgs：返回目标方法的参数
     *
     * Signature getSignature：返回目标方法的签名
     *
     * Object getTarget：返回被织入增强处理的目标对象
     *
     * Object getThis：返回AOP框架为目标对象生成的代理对象
     * @param pjp
     * @return
     */
   /* @Around("@annotation(com.example.photodemo.aspect.annotion.Author)")
    public Object around(ProceedingJoinPoint pjp){
        System.err.println(" 自定义注解切口部分.......");
        // 返回目标方法的参数
        Object[] args = pjp.getArgs();
        // 获取注解的方法
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        // 通过反射 获取方法的注解的实体类
        Author author = method.getAnnotation(Author.class);
        System.err.println(author.name());
        return null;
    }*/

    /**
     * ProceedingJoinPoint 必须做第一个参数
     *
     * @param pjp
     * @return
     */
    @Around("@annotation(author)")
    public Object around(ProceedingJoinPoint pjp, Author author) throws Throwable {
        String name = getKey(author.name(), pjp);
        System.err.println(name);
        // 获取类名 com.example.photodemo.controller.AspectController
        String className = pjp.getSourceLocation().getWithinType().getName();
        System.err.println(className);
        // 获取方法名 getParamDemo
        String methodName = pjp.getSignature().getName();
        System.err.println(methodName);
        // return pjp.proceed();
        return "我本来返回的是： " +pjp.proceed()+ "，但过滤器改变了我的值";
    }

    /**
     * 获取注解参数的值
     * @param key
     * @param pjp
     * @return
     */
    private String getKey(String key,ProceedingJoinPoint pjp){
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        /**
         * LocalVariableTableParameterNameDiscoverer 获取方法参数名
         * Java.lang.reflect 包中提供了很多方法，获取所有的方法，获取所有的参数类型等，但是却没有一个方法能够帮助我们获取方法的参数名列表。
         * 可以通过ASM提供的通过字节码获取方法的参数名称，spring给我们集成了这个东西，让我们使用起来非常的方便
         */
        String[] parameterNames = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);
        Object[] args = pjp.getArgs();
        return SpelParser.getKey(key,parameterNames,args);
    }

}
