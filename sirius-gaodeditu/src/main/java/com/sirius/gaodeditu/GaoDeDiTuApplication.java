package com.sirius.gaodeditu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class GaoDeDiTuApplication {
    public static void main(String[] args) {
        SpringApplication.run(GaoDeDiTuApplication.class,args);
        System.out.println("GaoDeApi已启动");
    }
}
