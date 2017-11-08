package com.dmxiaoshen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hzhsg on 2017/11/8.
 */
@RestController
@RequestMapping("/consumer/dc")
public class DcConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/description")
    public Object dcDescription(){
        return restTemplate.getForObject("http://eureka-client-dmxs/dc/description",Object.class);
    }
}
