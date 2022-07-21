package com.sirius.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    /**
     * 接口测试
     * @return
     */
    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public String demo(){
        return "你好,世界";
    }
}
