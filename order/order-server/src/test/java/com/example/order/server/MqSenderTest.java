package com.example.order.server;

import com.example.order.server.message.StreamClient;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Date;

/**
 * 发送mq消息
 * Created By ChengHao On 2020/2/8
 */
@SpringBootTest
public class MqSenderTest {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private StreamClient streamClient;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("myQueue","now: "+new Date());
    }

    @Test
    public void sendComputer(){
        amqpTemplate.convertAndSend("myOrder","computer","now: "+new Date());
    }

    @Test
    public void streamSend(){
        streamClient.output().send(MessageBuilder.withPayload("now: "+new Date()).build());
    }
}
