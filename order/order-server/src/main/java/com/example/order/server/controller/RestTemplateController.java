package com.example.order.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 通过 RestTemplate 调用远程服务的三种方式
 * Created By ChengHao On 2020/2/5
 */
@RestController
@Slf4j
public class RestTemplateController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/getProductMsgByRest")
    public String getProductMsg(){
//        RestTemplate restTemplate = new RestTemplate();

        //1.第一种方式(直接使用restTemplate，url写死）
//        String response = restTemplate.getForObject("http://localhost:8081/msg",String.class);

        //2.第二种方式（利用loadBalancerClient通过应用名获取url,然后使用restTemplate）
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"msg";
//        String response = restTemplate.getForObject(url,String.class);

        //3.第三种方式(利用@LoadBalanced注解，可在restTemplate里使用应用名字
        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);
        log.info("response={}",response);
        return response;
    }
}
