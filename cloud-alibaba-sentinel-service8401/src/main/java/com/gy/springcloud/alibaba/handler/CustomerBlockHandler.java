package com.gy.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {

    public static String customerBlockExceptionHandler(BlockException blockException) {
        return blockException.getClass().getCanonicalName() + "  ----  Service is not available! [handler outside from origin class]";
    }
}
