package com.viper.ckframework.keymanager.service;

import com.viper.ckframework.keymanager.model.ApiTokenDto;
import com.viper.ckframework.keymanager.model.GetApiTokensResponse;

public interface ApiTokenService {
    String getJwks();
    ApiTokenDto generateApiToken();

    GetApiTokensResponse getTokens();
}
