package com.sirius.demo.thread.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sirius.demo.thread.entity.ParameterEntity;
import com.sirius.demo.thread.mapper.ParameterMapper;
import com.sirius.demo.thread.service.IParameterService;
import org.springframework.stereotype.Service;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName ParameterServiceImpl.java
 * @Description TODO
 * @createTime 2022年08月03日 16:02:00
 */
@Service
public class ParameterServiceImpl extends ServiceImpl<ParameterMapper, ParameterEntity> implements IParameterService {
}
