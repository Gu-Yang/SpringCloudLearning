package com.gy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NonRefreshConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info2}")
    private String configInfo;

    @GetMapping("/configInfo2")
    public String getConfigInfo() {
        return "ServerPort: " + serverPort + "\t\n\n ConfigInfo: " + configInfo;
    }
}
