package com.dmxiaoshen.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hzhsg on 2017/11/21.
 */
@FeignClient("eureka-client-dmxs")
public interface DcClient {

    @GetMapping("/dc/hystrix/test")
    public String hystrixTest(@RequestParam("title")String title);
}
