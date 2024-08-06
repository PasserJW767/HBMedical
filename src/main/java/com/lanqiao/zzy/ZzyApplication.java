package com.lanqiao.zzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.lanqiao.zzy.mapper"})//扫描映射器接口
public class ZzyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzyApplication.class, args);
    }

}
