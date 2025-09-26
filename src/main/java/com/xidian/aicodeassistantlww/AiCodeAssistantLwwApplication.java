package com.xidian.aicodeassistantlww;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
@MapperScan("com.xidian.aicodeassistantlww.mapper")
public class AiCodeAssistantLwwApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiCodeAssistantLwwApplication.class, args);
    }

}
