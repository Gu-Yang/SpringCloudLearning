package com.gy.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.gy.springcloud.alibaba.handler.CustomerBlockHandler;
import com.gy.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @SentinelResource(value = "byResource", blockHandler = "handleResourceException", fallback = "customerGeneralExceptionHandler", exceptionsToIgnore = ArithmeticException.class)
    @GetMapping("/byResource")
    public String byResource() {
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int i = 1/0;
        return "Access resource name limit API successfully!";
    }

    public String customerGeneralExceptionHandler(Throwable t) {
        return t.getClass().getCanonicalName() + "  ----  Failed to process this request, Exception: " + t.getMessage();
    }

    public String handleResourceException(BlockException blockException) {
        return blockException.getClass().getCanonicalName() + "  ----  Service is not available!";
    }
}
