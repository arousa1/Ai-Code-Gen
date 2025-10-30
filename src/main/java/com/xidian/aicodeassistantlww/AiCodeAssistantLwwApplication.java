package com.xidian.aicodeassistantlww;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableCaching
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.xidian.aicodeassistantlww.mapper")
@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
public class AiCodeAssistantLwwApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiCodeAssistantLwwApplication.class, args);
    }

}
