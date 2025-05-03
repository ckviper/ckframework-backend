package com.viper.ckframework.gateway.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class DefaultJwtDecoder implements ReactiveJwtDecoder {
    private final JWSVerifier jwsVerifier;

    @Override
    public Mono<Jwt> decode(String token) throws JwtException {
        return Mono.fromCallable(() -> {
            SignedJWT signedJwt = SignedJWT.parse(token);
            if (!signedJwt.verify(jwsVerifier)) {
                throw new JOSEException("Failed to verify JWT signature");
            }
            JWTClaimsSet claimsSet = signedJwt.getJWTClaimsSet();
            Map<String, Object> mappedClaims = new HashMap<>();
            for (String key : claimsSet.getClaims().keySet()) {
                Object value = claimsSet.getClaim(key);
                if ("exp".equals(key) || "iat".equals(key)) {
                    value = claimsSet.getDateClaim(key).toInstant();
                }
                mappedClaims.put(key, value);
            }
            return Jwt.withTokenValue(token)
                    .headers(headers -> headers.putAll(signedJwt.getHeader().toJSONObject()))
                    .claims(claims -> claims.putAll(mappedClaims))
                    .build();
        }).onErrorMap(e -> new JwtException("Failed to decode JWT: " + e.getMessage(), e));
    }
}
