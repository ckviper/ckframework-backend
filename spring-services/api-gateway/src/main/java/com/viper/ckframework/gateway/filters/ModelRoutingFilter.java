package com.viper.gateway.filters;

import com.viper.gateway.config.ModelConfig;
import com.viper.gateway.config.ModelsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import reactor.netty.http.client.HttpClient;

import java.net.URI;

@Slf4j
@Component
public class ModelRoutingFilter extends AbstractGatewayFilterFactory<ModelRoutingFilter.Config> {

    @Autowired
    private ModelsConfig modelsConfig;

    public ModelRoutingFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String modelId = exchange.getRequest().getQueryParams().getFirst("modelId");
            if (modelId == null) {
                exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                return exchange.getResponse().setComplete();
            }

            ModelConfig modelConfig = modelsConfig.getModels().stream()
                    .filter(m -> m.getModelId().equals(modelId))
                    .findFirst()
                    .orElse(null);

            if (modelConfig == null) {
                exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
                return exchange.getResponse().setComplete();
            }

            URI targetUri = UriComponentsBuilder.newInstance()
                    .scheme("http")
                    .host("localhost")
                    .port(modelConfig.getHost())
                    .path("/v1/chat/completions")
                    .query(exchange.getRequest().getURI().getRawQuery())
                    .build()
                    .toUri();

            log.info("Routing request to: {}", targetUri);
            
            exchange.getAttributes().put(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR, targetUri);
            exchange.getAttributes().put(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR,
                    Route.async()
                            .id("dynamic_model_route")
                            .uri(targetUri)
                            .predicate(e -> true)
                            .build());
            
            ServerHttpRequest modifiedRequest = exchange.getRequest().mutate()
                    .uri(targetUri)
                    .build();

            return chain.filter(exchange.mutate().request(modifiedRequest).build())
                    .then(Mono.fromRunnable(() -> {
                        if (exchange.getResponse().getStatusCode() == HttpStatus.OK) {
                            log.info("Received response from target server");
                        }
                    }));
        };
    }

    public static class Config {
        
    }
}
