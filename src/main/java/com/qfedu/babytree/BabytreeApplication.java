package com.qfedu.babytree;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 著作人：第七组（育宝宝）---》彭奕茗，567，BlingBling,王炎彬，刘寒冰，何东伟，董润华
 */
@SpringBootApplication
@MapperScan(value = "com.qfedu.babytree.mapper")
public class BabytreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BabytreeApplication.class, args);
    }
}
