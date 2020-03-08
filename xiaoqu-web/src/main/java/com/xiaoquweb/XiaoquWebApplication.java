package com.xiaoquweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaoquweb.dao")
public class XiaoquWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoquWebApplication.class, args);
    }

}
