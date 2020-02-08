package com.example.order.server.controller;

import com.example.order.server.dto.OrderDTO;
import com.example.order.server.message.StreamClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * SpringCloud Stream 生产者
 * Created By ChengHao On 2020/2/8
 */
@RestController
@Slf4j
public class SendMessageController {
    @Autowired
    private StreamClient streamClient;

    /**
     * 发送 OrderDTO 对象
     */
    @GetMapping("/sendMessage")
    public void process(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }

}
