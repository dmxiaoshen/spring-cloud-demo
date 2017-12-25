package com.dmxiaoshen.controller;

import com.dmxiaoshen.client.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by hzhsg on 2017/11/8.
 */
@RestController
@RequestMapping("/consumer/dc")
public class DcConsumerController {

    @Autowired
    private DcClient dcClient;

    @GetMapping("/description")
    public Object dcDescription(){
        return dcClient.getDescription();
    }

    @GetMapping("/param/date")
    public String getParamDate(){
        return dcClient.testDateParam("1", new Date());
    }

    @GetMapping("/post/body")
    public String postBody(){
        return dcClient.testBody(null);
    }
}
