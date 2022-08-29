package com.sirius.gaodeditu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GaoDeDiTuApplication {
    public static void main(String[] args) {
        SpringApplication.run(GaoDeDiTuApplication.class,args);
        System.out.println("GaoDeApi已启动");
    }
}
