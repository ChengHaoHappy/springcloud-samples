package com.example.order.server.controller;

import com.example.product.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created By ChengHao On 2020/2/5
 */
@RestController
@Slf4j
public class ClientController {
    @Resource
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        String response = productClient.getProductMsgByFeign();
        log.info("response={}",response);
        return response;
    }
}
