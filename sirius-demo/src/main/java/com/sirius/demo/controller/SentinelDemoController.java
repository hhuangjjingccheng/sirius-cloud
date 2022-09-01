package com.sirius.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelDemoController {

    /**
     * 接口测试
     * @return
     */
    @RequestMapping(value = "/sentinelDemo1",method = RequestMethod.GET)
    public String sentinelDemo1(){
        return "你好,世界1";
    }

    /**
     * 接口测试
     * @return
     */
    @RequestMapping(value = "/sentinelDemo2",method = RequestMethod.GET)
    public String sentinelDemo2(){
        return "你好,世界2";
    }
}
