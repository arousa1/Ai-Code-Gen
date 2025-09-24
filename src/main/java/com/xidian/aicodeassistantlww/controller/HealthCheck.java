package com.xidian.aicodeassistantlww.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口健康检查
 */

@RestController
@RequestMapping("/health")
public class HealthCheck {

    @GetMapping("/check")
    public String healthCheck() {
        return "OK";
    }

}
