package service;

import entity.TokenUsageEntity;

import java.util.List;

public interface TokenUsageService {
    TokenUsageEntity createTokenUsageEntity(TokenUsageEntity TokenUsageEntity);
    TokenUsageEntity getTokenUsageEntityById(Long id);
    TokenUsageEntity updateTokenUsageEntity(Long id, TokenUsageEntity updatedTokenUsageEntity);
    void deleteTokenUsageEntity(Long id);
    List<TokenUsageEntity> getAllTokenUsageEntity();
    List<TokenUsageEntity> getTokenUsageEntityByTokenId(Long tokenId);
    List<TokenUsageEntity> getTokenUsageEntityByModelId(Long modelId);
}
