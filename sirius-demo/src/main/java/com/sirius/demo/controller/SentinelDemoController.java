package com.sirius.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sirius.common.utils.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelDemoController {

    /**
     * 接口测试
     * @return
     */
    @SentinelResource(value = "annotest",blockHandler = "handleException")
    @RequestMapping(value = "/sentinelDemo1",method = RequestMethod.GET)
    public String sentinelDemo1(){
        return "你好,世界1";
    }

    /**
     * 接口测试
     * @return
     */
    @SentinelResource(value = "sentinelDemo2",blockHandler = "demoException",blockHandlerClass = {SentinelExceptionUtil.class})
    @RequestMapping(value = "/sentinelDemo2",method = RequestMethod.GET)
    public String sentinelDemo2(){
        return "你好,世界2";
    }

    /**
     * 异常处理
     * 处理器方法修饰必须为 public
     * @param e 参数需要使用 BlockException，是 Sentinel 提供的异常类
     * @return 返回数据会作为 Controller 方法的返回
     */
    public String handleException(BlockException e) {
        e.printStackTrace();
        System.out.println(e.getClass());
        return "系统繁忙，稍后重试";
    }
}
