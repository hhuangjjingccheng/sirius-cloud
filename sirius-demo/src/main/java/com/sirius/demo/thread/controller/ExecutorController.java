package com.sirius.demo.thread.controller;

import com.sirius.demo.thread.service.IExecutorService;
import com.sirius.demo.thread.service.IGoodsSortDetailService;
import com.sirius.demo.thread.service.IParameterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName ExecutorController.java
 * @Description TODO
 * @createTime 2022年08月03日 15:45:00
 */
@RestController
@RequestMapping("/thread")
@Log4j2
public class ExecutorController {

    @Resource
    private IParameterService iParameterService;

    @Resource
    private IGoodsSortDetailService iGoodsSortDetailService;

    @Resource
    private IExecutorService iExecutorService;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public void test(){
        log.info("开始测试");
        iExecutorService.test();
    }
}
