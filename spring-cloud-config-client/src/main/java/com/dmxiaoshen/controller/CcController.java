package com.dmxiaoshen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by hzhsg on 2017/11/8.
 */
@RestController
@RequestMapping("/cc")
public class CcController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/description")
    public Object getDescription(){
        try {
            return new ObjectMapper().readTree("{\"info\":\"config-client-dmxs,hello port: "+port+"!\"}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
