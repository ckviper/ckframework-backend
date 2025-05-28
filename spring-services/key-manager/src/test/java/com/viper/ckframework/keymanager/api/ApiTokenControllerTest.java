package com.viper.ckframework.keymanager.api;

import com.viper.ckframework.keymanager.model.ApiTokenDto;
import com.viper.ckframework.keymanager.model.GetApiTokensResponse;
import com.viper.ckframework.keymanager.service.ApiTokenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiTokenController.class)
class ApiTokenControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiTokenService service;

    @Test
    void generateTokenEndpointReturnsDto() throws Exception {
        when(service.generateApiToken()).thenReturn(new ApiTokenDto("jwt"));

        mockMvc.perform(get("/v1/token/generate"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"api_token\":\"jwt\"}"));
    }

    @Test
    void getTokensEndpointReturnsList() throws Exception {
        when(service.getTokens()).thenReturn(new GetApiTokensResponse());

        mockMvc.perform(get("/v1/token"))
                .andExpect(status().isOk());
    }
}
