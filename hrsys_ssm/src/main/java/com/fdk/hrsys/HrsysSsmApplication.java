package com.fdk.hrsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fdk.hrsys.dao") // 【核心】必须要有这一行，否则找不到 EmployeeDao
public class HrsysSsmApplication {
    public static void main(String[] args) {
        SpringApplication.run(HrsysSsmApplication.class, args);
    }
}