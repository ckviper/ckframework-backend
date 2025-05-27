package service;

import entity.TokenEntity;
import entity.TokenUsageEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.TokenRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private TokenRepository tokenRepository;

    @Override
    public TokenEntity createTokenEntity(TokenEntity TokenEntity) {
        return null;
    }

    @Override
    public TokenEntity getTokenEntityById(Long id) {
        return null;
    }

    @Override
    public TokenEntity updateTokenEntity(Long id, TokenEntity updatedTokenEntity) {
        return null;
    }

    @Override
    public void deleteTokenEntity(Long id) {

    }

    @Override
    public List<TokenEntity> getAllTokenEntity() {
        return List.of();
    }

    @Override
    public TokenEntity getTokenEntityByValue(String TokenEntityValue) {
        return null;
    }

    @Override
    public List<TokenUsageEntity> getTokenEntityUsagesForTokenEntity(Long TokenEntityId) {
        return List.of();
    }
}
