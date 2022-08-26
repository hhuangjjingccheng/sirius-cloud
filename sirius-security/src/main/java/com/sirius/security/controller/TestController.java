package com.sirius.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class TestController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "Security 接口测试";
    }
}
