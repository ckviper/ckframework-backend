package com.viper.ckframework.keymanager.api;

import com.viper.ckframework.keymanager.model.ApiTokenDto;
import com.viper.ckframework.keymanager.model.GetApiTokensResponse;

import com.viper.ckframework.keymanager.service.ApiTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiTokenController implements ApiTokenApi {
    private final ApiTokenService apiTokenService;

    @Override
    public ResponseEntity<ApiTokenDto> generateToken() {
        return ResponseEntity.ok(apiTokenService.generateApiToken());
    }

    @Override
    public ResponseEntity<String> getJwks() {
        return ResponseEntity.ok(apiTokenService.getJwks());
    }

    @Override
    public ResponseEntity<GetApiTokensResponse> getTokens() {
        return ResponseEntity.ok(apiTokenService.getTokens());
    }
}
