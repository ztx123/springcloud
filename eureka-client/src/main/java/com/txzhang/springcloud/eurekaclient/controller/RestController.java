package com.txzhang.springcloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/restTest")
    public String restTest() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://baidu.com", String.class);
    }

    @RequestMapping("/hi")
    public String hi(String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
