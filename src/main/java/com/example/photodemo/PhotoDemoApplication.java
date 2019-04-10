package com.example.photodemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * SpringBootApplication注解，它包括三个注解： @Configuration：表示将该类作用springboot配置文件类。@EnableAutoConfiguration:表示程序启动时，自动加载springboot默认的配置。 @ComponentScan:表示程序启动是，自动扫描当前包及子包下所有类。
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.example.photodemo.dao*")  //  开启dao的扫描 mysqlplus
public class PhotoDemoApplication {

    //  spring boot 注入 restTemplate
    // 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例
    @Autowired
    private RestTemplateBuilder builder;
    // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
    @Bean   // @Bean是一个方法级别上的注解，主要用在@Configuration注解的类里，也可以用在@Component注解的类里。添加的bean的id为方法名
    public RestTemplate restTemplate(){
        return builder.build();
    }



    public static void main(String[] args) {
        SpringApplication.run(PhotoDemoApplication.class, args);
    }
}
