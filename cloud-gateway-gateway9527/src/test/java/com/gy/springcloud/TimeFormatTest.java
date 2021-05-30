package com.gy.springcloud;

import org.junit.jupiter.api.Test;
import org.springframework.cloud.gateway.handler.predicate.AfterRoutePredicateFactory;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class TimeFormatTest {
//    @Test
//    public void getTime() {
//        AfterRoutePredicateFactory.Config config = new AfterRoutePredicateFactory.Config();
//        System.out.println(config.getDatetime());
//    }

    public static void main(String[] args) {
        AfterRoutePredicateFactory.Config config = new AfterRoutePredicateFactory.Config();
        System.out.println(config.getDatetime());
    }
}
