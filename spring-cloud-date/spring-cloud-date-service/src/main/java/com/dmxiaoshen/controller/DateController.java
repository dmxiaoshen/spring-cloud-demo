package com.dmxiaoshen.controller;

import com.dmxiaoshen.entity.Music;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by hzhsg on 2017/12/5.
 */
@RestController
@RequestMapping("/server")
public class DateController {

    /**
     * fegin的get方法不能传对象
     * @param music
     * @return
     */
    @PostMapping("/music/query")
    public Music getMusic(@RequestBody Music music){
        return music;
    }

    @GetMapping("/music/date")
    public Music queryMusic(@RequestParam("publishDate") Date publishDate){
        Music music = new Music();
        music.setPublishDate(publishDate);
        return music;
    }

    @PostMapping("/music")
    public Music add(@RequestBody Music music){
        return music;
    }
}
