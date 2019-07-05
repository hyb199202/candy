package com.candymanage.candy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.candymanage.candy.dao")
public class CandyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CandyApplication.class, args);
    }

}
