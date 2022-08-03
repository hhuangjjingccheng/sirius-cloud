package com.sirius.demo.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sirius.demo.demo.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName TestMapper.java
 * @Description TODO
 * @createTime 2022年08月03日 15:36:00
 */
@Mapper
public interface TestMapper extends BaseMapper<TestEntity> {
}
