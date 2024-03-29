package com.xay.rabbitmqprovider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ziling.wang@hand-china.com
 * @description
 * @date 2020/10/18 21:35
 **/
@Configuration
public class TopicRabbitConfig {

    public static final String man = "topic.man";
    public static final String woman = "topic.woman";
    public static final String all = "topic.all";

    @Bean
    public Queue firstQueue() {
        return new Queue(man);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(woman);
    }

    public Queue thirdQueue() {return new Queue(all);}

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 将firstQueue和topicExchange绑定,而且绑定的键值为topic.man
     * 这样只要是消息携带的路由键是topic.man,才会分发到该队列
     */
    @Bean
    public Binding bindingExchangeMessage() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(man);
    }

    /**
     * 将secondQueue和topicExchange绑定,而且绑定的键值为topic.woman
     * 这样只要是消息携带的路由键是topic.woman,才会分发到该队列
     */
    @Bean
    public Binding bindingExchangeMessage2() {return BindingBuilder.bind(secondQueue()).to(exchange()).with(woman);}

    /**
     * 将thirdQueue和topicExchange绑定,而且绑定的键值为用上通配路由键规则topic.#
     * 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
     */
    @Bean
    public Binding bindingExchangeMessage3() {
        return BindingBuilder.bind(thirdQueue()).to(exchange()).with("topic.#");
    }
}
