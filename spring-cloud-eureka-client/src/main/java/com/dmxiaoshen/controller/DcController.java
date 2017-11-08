package com.dmxiaoshen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhsg on 2017/11/7.
 */
@RestController
@RequestMapping("/dc")
public class DcController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/services")
    public String getServices(){
        return Arrays.toString(discoveryClient.getServices().toArray());
    }

    @GetMapping("/description")
    public Object getDescription(){
        Map<String,Object> maps = new HashMap<>();
        maps.put("description",discoveryClient.description());
        return maps;
    }
}
