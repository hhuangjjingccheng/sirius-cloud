package com.sirius.demo.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sirius.demo.demo.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName TestMapper.java
 * @Description TODO
 * @createTime 2022年08月03日 15:36:00
 */
@Mapper
public interface TestMapper extends BaseMapper<TestEntity> {

    /**
     * 测试Mybatis-plus
     *
     * @return
     */
    List<TestEntity> testEntityList();
}
