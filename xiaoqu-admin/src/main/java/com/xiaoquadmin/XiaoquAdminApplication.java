package com.xiaoquadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaoquadmin.dao")
public class XiaoquAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoquAdminApplication.class, args);
    }

}
