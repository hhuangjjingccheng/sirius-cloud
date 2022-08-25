package com.sirius.zookeeper.controller;

import com.sirius.zookeeper.api.ZookeeperApi;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/zookeeper")
public class ZookeeperController {

    private static final Logger logger = LoggerFactory.getLogger(ZookeeperController.class);

    @Resource
    private ZookeeperApi zookeeperApi;

    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public void demo(){
        zookeeperApi.createNode("/demo","你好，世界");
    }

    @RequestMapping(value = "/getData",method = RequestMethod.GET)
    public void getData(){
        String s = zookeeperApi.getData("/sanguo",null);

        logger.info(s);
    }
}
