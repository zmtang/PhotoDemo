package com.example.photodemo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 队列配置，队列的名称，发送者和接受者的名称必须一致，否则接收不到消息
 * @author zmt
 * @date 2019-03-29 17:40
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue(){
        return new Queue("photoDemo1");
    }

}
