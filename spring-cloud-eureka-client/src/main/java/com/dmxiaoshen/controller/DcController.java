package com.dmxiaoshen.controller;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by hzhsg on 2017/11/7.
 */
@RestController
@RequestMapping("/dc")
public class DcController {

    private Logger logger = LoggerFactory.getLogger(getClass());

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

    @GetMapping("/param/date")
    public String testDateParam(@RequestParam("id")String id,@RequestParam("date")Date date){
        return id+"-"+DateFormatUtils.format(date,"yyyy-MM-dd");
    }

    @GetMapping("/hystrix/test")
    public String hystrixTest(@RequestParam("title")String title) throws InterruptedException {
        int flag = new Random().nextInt(100);
        logger.info("---flag:{}",flag);
        if(flag%2==0) {
            Thread.sleep(5000L);
        }
        return "hello:"+title;
    }

    @PostMapping("/post/body")
    public String testBody(@RequestBody(required = false)List<String> list){
        return "success body";
    }
}
