package com.dmxiaoshen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hzhsg on 2017/11/7.
 */
@RestController
@RequestMapping("/consumer/dc")
public class DcConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/description")
    public Object dcDescription(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client-dmxs");
        String url = new StringBuilder("http://").append(serviceInstance.getHost()).append(":").append(serviceInstance.getPort()).append("/dc/description").toString();
        return restTemplate.getForObject(url,Object.class);
    }
}
