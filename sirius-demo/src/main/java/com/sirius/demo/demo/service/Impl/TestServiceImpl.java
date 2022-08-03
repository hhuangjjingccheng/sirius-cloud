package com.sirius.demo.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sirius.demo.demo.entity.TestEntity;
import com.sirius.demo.demo.mapper.TestMapper;
import com.sirius.demo.demo.service.ITestService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName TestServiceImpl.java
 * @Description TODO
 * @createTime 2022年08月03日 15:35:00
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestEntity> implements ITestService {
}
