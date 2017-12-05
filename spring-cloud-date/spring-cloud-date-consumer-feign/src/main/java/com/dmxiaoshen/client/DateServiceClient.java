package com.dmxiaoshen.client;

import com.dmxiaoshen.entity.Music;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by hzhsg on 2017/12/5.
 */
@FeignClient("spring-cloud-date-service")
public interface DateServiceClient {

    @PostMapping("/server/music/query")
    public Music getMusic(Music music);

    @GetMapping("/server/music/date")
    public Music queryMusic(@RequestParam("publishDate") Date publishDate);

    @PostMapping("/server/music")
    public Music add(@RequestBody Music music);
}
