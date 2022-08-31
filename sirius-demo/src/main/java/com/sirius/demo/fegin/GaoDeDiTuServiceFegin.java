package com.sirius.demo.fegin;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "sirius-gaodeditu")
public interface GaoDeDiTuServiceFegin {
}
