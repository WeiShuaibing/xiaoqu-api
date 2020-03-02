package com.yqyjadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yqyjadmin.dao")
public class YqyjAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(YqyjAdminApplication.class, args);
    }

}
