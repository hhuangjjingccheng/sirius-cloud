package com.sirius.demo.demo.controller;

import com.sirius.demo.demo.entity.TestEntity;
import com.sirius.demo.demo.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description TODO
 * @createTime 2022年08月03日 15:31:00
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService iTestService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public List<TestEntity> list(){
        return iTestService.list();
    }

    @RequestMapping(value = "/testEntityList",method = RequestMethod.POST)
    public List<TestEntity> testEntityList(){
        return iTestService.testEntityList();
    }
}
