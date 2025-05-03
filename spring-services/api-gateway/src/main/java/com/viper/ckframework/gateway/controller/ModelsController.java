package com.viper.ckframework.gateway.controller;

import com.viper.ckframework.gateway.config.ModelConfig;
import com.viper.ckframework.gateway.config.ModelsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ModelsController {
    private final ModelsConfig modelsConfig;

    @GetMapping("v1/models")
    public Mono<List<ModelConfig>> getModelsConfig() {
        return Mono.just(modelsConfig.getModels());
    }

    @GetMapping("v1/models/{modelId}")
    public Mono<ModelConfig> getModelConfig(@PathVariable String modelId) {
        return Mono.justOrEmpty(
                modelsConfig.getModels().stream()
                        .filter(modelConfig -> modelConfig.getName().equals(modelId))
                        .findFirst()
        );
    }
}
