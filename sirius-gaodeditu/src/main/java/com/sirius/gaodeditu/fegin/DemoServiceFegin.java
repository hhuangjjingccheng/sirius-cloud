package com.sirius.gaodeditu.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "sirius-demo",path = "/sirius-demo")
public interface DemoServiceFegin {

    @RequestMapping(value = "demo",method = RequestMethod.GET)
    String demo();
}
