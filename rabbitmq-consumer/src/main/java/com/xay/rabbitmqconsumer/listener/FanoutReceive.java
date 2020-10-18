package com.xay.rabbitmqconsumer.listener;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ziling.wang@hand-china.com
 * @description
 * @date 2020/10/18 21:50
 **/
@Component
public class FanoutReceive {

    @RabbitHandler
    @RabbitListener(queues = "fanout.A")
    public void processA(Map message) {
        System.out.println("fanout.A接收到消息：" + message);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.B")
    public void processB(Map message) {
        System.out.println("fanout.B接收到消息：" + message);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.C")
    public void processC(Map message) {
        System.out.println("fanout.C接收到消息：" + message);
    }
}
