package com.viper.ckframework.keymanager.service;

import com.viper.ckframework.keymanager.entity.ApiTokenEntity;
import com.viper.ckframework.keymanager.jwt.JwtClaimsManager;
import com.viper.ckframework.keymanager.jwt.JwtGenerator;
import com.viper.ckframework.keymanager.mapper.TokenMapper;
import com.viper.ckframework.keymanager.model.ApiTokenDto;
import com.viper.ckframework.keymanager.model.GetApiTokensResponse;
import com.viper.ckframework.keymanager.repository.TokenRepository;
import com.nimbusds.jose.jwk.JWKSet;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiTokenServiceImpl implements ApiTokenService {
    private final JWKSet jwkSet;
    private final JwtClaimsManager jwtClaimsManager;
    private final JwtGenerator jwtGenerator;
    private final TokenRepository repository;

    @Qualifier("tokenMapperImpl")
    private final TokenMapper mapper;


    @Override
    public String getJwks() {
        return jwkSet.toPublicJWKSet().toString();
    }

    @Override
    public ApiTokenDto generateApiToken() {
        String jwt = jwtGenerator.generate();
        String userId = jwtClaimsManager.extractUserId();

        ApiTokenEntity apiTokenEntity = ApiTokenEntity.builder()
                .apiToken(jwt)
                .userId(userId)
                .build();

        repository.save(apiTokenEntity);

        return new ApiTokenDto(jwt);
    }

    @Override
    public GetApiTokensResponse getTokens() {
        String userId = jwtClaimsManager.extractUserId();
        List<ApiTokenDto> apiTokenDtos = mapper.toListDto(repository.findAllByUserId(userId));
        return new GetApiTokensResponse().tokens(apiTokenDtos);
    }
}
