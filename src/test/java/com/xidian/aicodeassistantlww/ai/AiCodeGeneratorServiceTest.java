package com.xidian.aicodeassistantlww.ai;

import com.xidian.aicodeassistantlww.ai.model.HtmlCodeResult;
import com.xidian.aicodeassistantlww.ai.model.MultiFileCodeResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiCodeGeneratorServiceTest {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Test
    void generateHtmlCode() {
        HtmlCodeResult generatedHtmlCode = aiCodeGeneratorService.generateHtmlCode("做个工作记录小工具，不超过20行代码");
        Assertions.assertNotNull(generatedHtmlCode);
    }

    @Test
    void generateMultiFileCode() {
        MultiFileCodeResult generatedHtmlCode = aiCodeGeneratorService.generateMultiFileCode("做个留言板，不超过20行代码");
        Assertions.assertNotNull(generatedHtmlCode);
    }
}