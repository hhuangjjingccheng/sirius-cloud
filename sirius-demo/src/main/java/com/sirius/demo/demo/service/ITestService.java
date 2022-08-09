package com.sirius.demo.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sirius.demo.demo.entity.TestEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName ITestService.java
 * @Description TODO
 * @createTime 2022年08月03日 15:34:00
 */
public interface ITestService extends IService<TestEntity> {

    /**
     *  测试Mybatis-plus
     * @return
     */
    List<TestEntity> testEntityList();

    List<TestEntity> testEntityList(String s);
}
