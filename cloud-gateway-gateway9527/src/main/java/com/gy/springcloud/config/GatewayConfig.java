package com.gy.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
//    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("order_route", r->r.path("/order/**").uri("http://localhost"));
        routes.route("payment_route", r->r.path("/payment/**").uri("http://localhost:8001"));
//        routes.route("baidu", r->r.path("/guonei").uri("http://news.baidu.com"));
        return routes.build();
    }
}
