package com.sirius.demo.redis.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName RedisDemoController.java
 * @Description TODO
 * @createTime 2022年08月09日 14:58:00
 */
@RestController
@RequestMapping("/redis")
@Log4j2
public class RedisDemoController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;



    @RequestMapping(value = "/duductStock",method = RequestMethod.POST)
    public String duductStock(){
        synchronized (this){
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock>0){
                int result = stock-1;
                stringRedisTemplate.opsForValue().set("stock",result+"");
                log.info("扣减成功，库存剩余："+result+"");
            }else {
                log.info("扣减失败，库存不足");
            }
            return "end";
        }

    }
}
