package com.clay.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(basePackages = "com.clay.system.mapper")
@SpringBootApplication
public class DrugSellSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugSellSystemApplication.class, args);
    }

}
