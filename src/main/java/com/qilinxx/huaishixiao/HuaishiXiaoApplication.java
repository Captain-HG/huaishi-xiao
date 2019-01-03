package com.qilinxx.huaishixiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@MapperScan
@SpringBootApplication
public class HuaishiXiaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuaishiXiaoApplication.class, args);
    }

}

