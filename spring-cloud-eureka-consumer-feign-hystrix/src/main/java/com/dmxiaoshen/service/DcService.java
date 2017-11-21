package com.dmxiaoshen.service;

import com.dmxiaoshen.client.DcClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hzhsg on 2017/11/21.
 */
@Service
public class DcService {

    @Autowired
    private DcClient dcClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public String hystrixTest(String title){
        return dcClient.hystrixTest(title);
    }

    public String fallback(String title){
        return "fallback:"+title;
    }
}
