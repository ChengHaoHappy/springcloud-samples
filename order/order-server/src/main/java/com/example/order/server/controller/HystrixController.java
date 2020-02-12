package com.example.order.server.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.Arrays;

/**
 * Spring Cloud Hystrix
 * Created By ChengHao On 2020/2/12
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    //超时设置
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //设置熔断
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求数达到后
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //熔断时钟
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //错误率
//    })
    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("number") Integer number) {
        if (number % 2 == 0) {
            return "success";
        }
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8081/product/listForOrder",
                Arrays.asList("157875196366160022"), String.class);
    }

    @HystrixCommand(fallbackMethod = "fallback")//对点容错处理
    @GetMapping("/test")
    public String test() {
        throw new RuntimeException();
    }

    /**
     * test 容错后的回调方法
     * 回调方法返回类型必须和处理的函数返回类型一致？？？
     *
     * @return
     */
    private String fallback() {
        return "太拥挤了，请稍后重试~~~";
    }

    /**
     * HystrixController 容错后的回调方法
     *
     * @return
     */
    private String defaultFallback() {
        return "默认提示：太拥挤了，请稍后重试~~~";
    }

}
