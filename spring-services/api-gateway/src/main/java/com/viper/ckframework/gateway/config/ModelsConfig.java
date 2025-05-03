package com.viper.ckframework.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "models")
@Setter
@Getter
public class ModelsConfig {
    private List<ModelConfig> models;
}
