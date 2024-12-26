package com.ch.houseitemplace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ch.houseitemplace.mapper")
public class HouseItemPlaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseItemPlaceApplication.class, args);
    }

}
