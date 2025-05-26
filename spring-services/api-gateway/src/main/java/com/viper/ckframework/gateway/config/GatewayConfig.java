package com.viper.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("options_route", r -> r.method("OPTIONS")
                        .and()
                        .path("/api/v1/chat/completions")
                        .filters(f -> f.setResponseHeader("Access-Control-Allow-Origin", "https://web.chatboxai.app "))
                        .uri("no:op"))
                .route("main_route", r -> r.path("/api/v1/chat/completions")
                        .uri("http://localhost:8080"))
                .build();
    }
}
