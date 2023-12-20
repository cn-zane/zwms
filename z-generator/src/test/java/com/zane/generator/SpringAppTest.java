package com.zane.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"com.zane.generator"}
)
@MapperScan("com.zane.generator.mapper")
public class SpringAppTest {
    public static void main(String[] args) {
        SpringApplication.run(SpringAppTest.class, args);
    }
}
