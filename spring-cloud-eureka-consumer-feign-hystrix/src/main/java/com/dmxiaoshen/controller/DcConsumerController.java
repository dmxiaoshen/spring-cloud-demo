package com.dmxiaoshen.controller;

import com.dmxiaoshen.service.DcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hzhsg on 2017/11/21.
 */
@RestController
@RequestMapping("/consumer/dc")
public class DcConsumerController {

    @Autowired
    private DcService dcService;

    @GetMapping("/hystrix/test")
    public String hystrix(@RequestParam("title")String title){
        return dcService.hystrixTest(title);
    }
}
