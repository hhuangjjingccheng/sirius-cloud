package com.sirius.demo.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sirius.demo.demo.entity.TestEntity;
import com.sirius.demo.demo.mapper.TestMapper;
import com.sirius.demo.demo.service.ITestService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName TestServiceImpl.java
 * @Description TODO
 * @createTime 2022年08月03日 15:35:00
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestEntity> implements ITestService {

    @Resource
    private TestMapper testMapper;

    /**
     * 测试Mybatis-plus
     *
     * @return
     */
    @Override
    public List<TestEntity> testEntityList() {
        return testMapper.testEntityList();
    }

    @Override
    public List<TestEntity> testEntityList(String s){
//        Collections.;
        TreeMap<String,Object> treeMap = new TreeMap<>();
        Map<String,Object> map = new HashMap<>();
        return null;
    }


}
