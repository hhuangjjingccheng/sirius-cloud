package com.sirius.common.utils;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SentinelExceptionUtil {

    public static String demoException(BlockException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return "捕获Sentinel异常测试";
    }
}
