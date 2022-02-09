package com.xay.rabbitmqconsumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ziling.wang@hand-china.com
 * @description
 * @date 2020/10/18 21:40
 **/
@Component
@RabbitListener(queues = "topic.man")
public class TopicManReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("topic.man 接收到消息：" + message);
    }
}
