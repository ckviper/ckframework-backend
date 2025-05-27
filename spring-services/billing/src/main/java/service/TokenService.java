package service;

import entity.TokenEntity;
import entity.TokenUsageEntity;

import java.util.List;

public interface TokenService {
    TokenEntity createTokenEntity(TokenEntity TokenEntity);
    TokenEntity getTokenEntityById(Long id);
    TokenEntity updateTokenEntity(Long id, TokenEntity updatedTokenEntity);
    void deleteTokenEntity(Long id);
    List<TokenEntity> getAllTokenEntity();
    TokenEntity getTokenEntityByValue(String TokenEntityValue);
    List<TokenUsageEntity> getTokenEntityUsagesForTokenEntity(Long TokenEntityId);
}
