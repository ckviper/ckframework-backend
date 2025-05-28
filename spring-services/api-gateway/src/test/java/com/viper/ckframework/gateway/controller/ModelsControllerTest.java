package com.viper.ckframework.gateway.controller;

import com.viper.ckframework.gateway.config.ModelConfig;
import com.viper.ckframework.gateway.config.ModelsConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(classes = {ModelsController.class, ModelsConfig.class})
@AutoConfigureWebTestClient
@TestPropertySource(properties = {
    "models.models[0].name=TestModel",
    "models.models[0].version=1.0",
    "models.models[0].model-id=test-id",
    "models.models[0].description=Test model",
    "models.models[0].endpoint=/v1/models/test",
    "models.models[0].host=8081"
})
class ModelsControllerTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    void getModelsConfigReturnsList() {
        webClient.get().uri("/v1/models")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(ModelConfig.class).hasSize(1);
    }

    @Test
    void getModelConfigReturnsModel() {
        webClient.get().uri("/v1/models/test-id")
            .exchange()
            .expectStatus().isOk()
            .expectBody(ModelConfig.class)
            .consumeWith(result -> {
                ModelConfig body = result.getResponseBody();
                assert body != null;
                assert "test-id".equals(body.getModelId());
            });
    }
}
