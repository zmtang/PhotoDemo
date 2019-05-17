package com.example.photodemo.configuration;


import com.example.photodemo.util.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册 拦截器
 * 推荐使用 WebMvcConfigurer
 * WebMvcConfigurationSupport 会导致 WebMvc自动配置失效
 * @author zmt
 * @date 2019-05-15 14:58
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Bean
    public MyInterceptor getMyInterceptor() {
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        /**
         * addPathPatterns 用于添加拦截规则  需要拦截的访问路径
         * excludePathPatterns 用户排除拦截  不需要拦截的路径，String数组类型可以写多个用","分割
         */
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/freemarker/**");
        // registry.addInterceptor(getMyInterceptor()).addPathPatterns("/dev/**"); // dev 不可以
        // registry.addInterceptor(getMyInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/getToken","/success");
        // registry.addInterceptor(new InterfaceAuthCheckInterceptor()).addPathPatterns("/api/**");
        // 如果interceptor中不注入redis或其他项目可以直接new，否则请使用上面这种方式

    }
}
