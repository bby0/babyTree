package com.qfedu.babytree;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.qfedu.babytree.mapper")
public class BabytreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BabytreeApplication.class, args);
    }
}
