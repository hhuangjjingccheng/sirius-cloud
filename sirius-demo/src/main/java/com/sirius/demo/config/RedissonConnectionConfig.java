package com.sirius.demo.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName RedissonConfig.java
 * @Description TODO
 * @createTime 2022年08月09日 17:16:00
 */
@Configuration
public class RedissonConnectionConfig {
//
//    private static final String REDIS = "redis://";
//
//    @Value("${spring.redis.host}")
//    private String redisHost;
//
//    @Value("${spring.redis.port}")
//    private String redisPort;
//
//    @Value("${spring.redis.database}")
//    private Integer redisDataBase;
//
//
//    @Bean
//    public Redisson redisson(){
//        Config config = new Config();
//        // 单机模式
//        config.useSingleServer().setAddress(REDIS+redisHost+":"+redisPort).setDatabase(redisDataBase);
//        return (Redisson) Redisson.create(config);
//    }

}
