package com.lp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lp.dao")
public class OracleSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(OracleSpringbootApplication.class, args);
    }

}
