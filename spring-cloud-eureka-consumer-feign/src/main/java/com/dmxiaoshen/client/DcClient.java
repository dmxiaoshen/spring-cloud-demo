package com.dmxiaoshen.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by hzhsg on 2017/11/8.
 */
@FeignClient("eureka-client-dmxs")
public interface DcClient {

    @GetMapping("/dc/description")
    Object getDescription();
}
