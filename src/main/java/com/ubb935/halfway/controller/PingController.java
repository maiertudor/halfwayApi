package com.ubb935.halfway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ping")
public class PingController {

    @RequestMapping("")
    @ResponseBody
    public String index() {
        return "pong";
    }

}
