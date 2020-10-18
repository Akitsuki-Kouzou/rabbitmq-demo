package com.xay.rabbitmqprovider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ziling.wang@hand-china.com
 * @description
 * @date 2020/10/18 14:40
 **/
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue testDirectQueue() {
        return new Queue("testDirectQueue",false);
    }

    @Bean
    public DirectExchange testDirectExchange() {
        return new DirectExchange("testDirectExchange",false,false);
    }

    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with("testDirectRouting");
    }

    @Bean
    public DirectExchange lonelyDirectExchange() {
        return new DirectExchange("lonelyDirectExchange",false,false);
    }
}
