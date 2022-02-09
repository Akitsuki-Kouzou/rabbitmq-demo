package com.xay.rabbitmqconsumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ziling.wang@hand-china.com
 * @date 2022/2/9 19:59
 */
@Component
@RabbitListener(queues = "topic.all")
public class TopicAllReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("topic.all 接收到消息：" + message);
    }
}
