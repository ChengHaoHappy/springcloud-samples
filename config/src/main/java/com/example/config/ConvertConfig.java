package com.example.config;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created By ChengHao On 2020/2/7
 */
@RestController
public class ConvertConfig {
    @PostMapping("/monito")
    public void convert(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/actuator/bus-refresh";
        restTemplate.postForEntity(url,null,String.class);
        System.out.println("convert");
    }

}
