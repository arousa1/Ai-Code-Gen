package com.xidian.aicodeassistantlww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class AiCodeAssistantLwwApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiCodeAssistantLwwApplication.class, args);
    }

}
