package com.sirius.demo.thread.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.sirius.demo.thread.entity.ParameterEntity;
import com.sirius.demo.thread.mapper.GoodsSortDetailMapper;
import com.sirius.demo.thread.mapper.ParameterMapper;
import com.sirius.demo.thread.service.IExecutorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName ExecutorServiceImpl.java
 * @Description TODO
 * @createTime 2022年08月03日 16:06:00
 */
@Service
public class ExecutorServiceImpl implements IExecutorService {

    @Resource
    private ParameterMapper parameterMapper;

    @Resource
    private GoodsSortDetailMapper goodsSortDetailMapper;

    /**
     * 测试线程是否可以优化查询
     */
    @Override
    public void test() {
        Map<String,List> map = new HashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(
                ()->{
                    QueryWrapper<ParameterEntity> queryWrapper = new QueryWrapper<>();
                    List<ParameterEntity> list = parameterMapper.selectList(queryWrapper);
                    map.put("Parameter",list);
                }
        );
    }
}
