package com.sirius.demo.thread.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sirius.demo.thread.entity.GoodsSortDetailEntity;
import com.sirius.demo.thread.mapper.GoodsSortDetailMapper;
import com.sirius.demo.thread.service.IGoodsSortDetailService;
import org.springframework.stereotype.Service;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName GoodsSortDetailServiceImpl.java
 * @Description TODO
 * @createTime 2022年08月03日 16:02:00
 */
@Service
public class GoodsSortDetailServiceImpl extends ServiceImpl<GoodsSortDetailMapper, GoodsSortDetailEntity>
        implements IGoodsSortDetailService {
}
