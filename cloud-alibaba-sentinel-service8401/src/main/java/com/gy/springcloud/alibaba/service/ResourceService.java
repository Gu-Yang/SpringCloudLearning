package com.gy.springcloud.alibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ResourceService {

    @SentinelResource("doSomething")
    public void doSomething() {
        log.info("doSomething!");
    }
}
