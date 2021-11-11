package com.gy.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.gy.springcloud.alibaba.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.internal.util.BlockingUtils;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ResourceService resourceService;

    @SentinelResource("testA")
    @GetMapping("/testA")
    public String testA() {
        log.info("TestA called");
//        resourceService.doSomething();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "Test A called successfully";
    }

    @SentinelResource("testB")
    @GetMapping("/testB")
    public String testB() {
        log.info("TestB called");
//        resourceService.doSomething();
//        testA();
        restTemplate.getForObject("http://localhost:8401/testA", String.class);
        return "Test B called successfully";
    }

    @GetMapping("/testD")
    public String testD() {
        log.info("TestD called");
        int i = 1/0;
        return "Test D called successfully";
    }

    @SentinelResource(value = "testHotkey")
    @GetMapping("/testHotkey")
    public String testHotkey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2) {
        return "Test Hotkey called successfully";
    }

    public String deal_testHotkey(String p1, String p2, BlockException blockException) {
        return "deal_testHotkey processed";
    }
}
