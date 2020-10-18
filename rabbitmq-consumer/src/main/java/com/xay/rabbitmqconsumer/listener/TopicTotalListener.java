package com.xay.rabbitmqconsumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ziling.wang@hand-china.com
 * @description
 * @date 2020/10/18 21:42
 **/
@Component
@RabbitListener(queues = "topic.woman")
public class TopicTotalListener {

    @RabbitHandler
    public void process(String message) {
        System.out.println("topic.woman接收到消息：" + message);
    }
}
