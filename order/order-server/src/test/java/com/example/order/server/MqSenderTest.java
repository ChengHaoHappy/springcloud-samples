package com.example.order.server;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * 发送mq消息
 * Created By ChengHao On 2020/2/8
 */
@SpringBootTest
public class MqSenderTest {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("myQueue","now: "+new Date());
    }

    @Test
    public void sendComputer(){
        amqpTemplate.convertAndSend("myOrder","computer","now: "+new Date());
    }
}
