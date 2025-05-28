package com.viper.ckframework.keymanager.service;

import com.nimbusds.jose.jwk.JWKSet;
import com.viper.ckframework.keymanager.entity.ApiTokenEntity;
import com.viper.ckframework.keymanager.jwt.JwtClaimsManager;
import com.viper.ckframework.keymanager.jwt.JwtGenerator;
import com.viper.ckframework.keymanager.mapper.TokenMapper;
import com.viper.ckframework.keymanager.model.ApiTokenDto;
import com.viper.ckframework.keymanager.repository.TokenRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ApiTokenServiceImplTest {
    @Test
    void generateApiTokenReturnsDtoAndSavesEntity() {
        JWKSet jwkSet = mock(JWKSet.class);
        JwtClaimsManager claimsManager = mock(JwtClaimsManager.class);
        JwtGenerator jwtGenerator = mock(JwtGenerator.class);
        TokenRepository repository = mock(TokenRepository.class);
        TokenMapper mapper = mock(TokenMapper.class);

        when(jwtGenerator.generate()).thenReturn("jwt-token");
        when(claimsManager.extractUserId()).thenReturn("user");
        when(mapper.toListDto(any())).thenReturn(Collections.emptyList());

        ApiTokenServiceImpl service = new ApiTokenServiceImpl(jwkSet, claimsManager, jwtGenerator, repository, mapper);

        ApiTokenDto dto = service.generateApiToken();

        assertThat(dto.getApiToken()).isEqualTo("jwt-token");
        ArgumentCaptor<ApiTokenEntity> captor = ArgumentCaptor.forClass(ApiTokenEntity.class);
        verify(repository).save(captor.capture());
        assertThat(captor.getValue().getApiToken()).isEqualTo("jwt-token");
        assertThat(captor.getValue().getUserId()).isEqualTo("user");
    }
}
