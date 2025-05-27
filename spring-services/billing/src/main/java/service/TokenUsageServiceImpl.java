package service;

import entity.TokenUsageEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.TokenUsageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TokenUsageServiceImpl implements TokenUsageService {
    private final TokenUsageRepository tokenUsageRepository;

    @Override
    public TokenUsageEntity createTokenUsageEntity(TokenUsageEntity TokenUsageEntity) {
        return null;
    }

    @Override
    public TokenUsageEntity getTokenUsageEntityById(Long id) {
        return null;
    }

    @Override
    public TokenUsageEntity updateTokenUsageEntity(Long id, TokenUsageEntity updatedTokenUsageEntity) {
        return null;
    }

    @Override
    public void deleteTokenUsageEntity(Long id) {

    }

    @Override
    public List<TokenUsageEntity> getAllTokenUsageEntity() {
        return List.of();
    }

    @Override
    public List<TokenUsageEntity> getTokenUsageEntityByTokenId(Long tokenId) {
        return List.of();
    }

    @Override
    public List<TokenUsageEntity> getTokenUsageEntityByModelId(Long modelId) {
        return List.of();
    }
}
