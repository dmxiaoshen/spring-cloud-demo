package com.dmxiaoshen.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by hzhsg on 2017/11/8.
 */
@FeignClient("eureka-client-dmxs")
public interface DcClient {

    @GetMapping("/dc/description")
    Object getDescription();

    @GetMapping("/dc/param/date")
    String testDateParam(@RequestParam("id")String id, @RequestParam("date")Date date);

    @PostMapping("/dc/post/body")
    public String testBody(@RequestBody(required = false)List<String> list);
}
