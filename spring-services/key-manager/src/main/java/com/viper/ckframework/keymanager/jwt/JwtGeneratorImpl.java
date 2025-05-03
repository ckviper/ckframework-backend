package com.viper.ckframework.keymanager.jwt;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtGeneratorImpl implements JwtGenerator{

    @Value("${JWK_KID}")
    private String jwkId;

    private final JWSSigner jwsSigner;
    private final JwtClaimsManager jwtClaimsManager;

    @Override
    @SneakyThrows
    public String generate() {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime expirationTime = currentTime.plusYears(1);
        String userId = jwtClaimsManager.extractUserId();
        String userIdString = (userId != null) ? userId.toString() : "anonymous";

        JWTClaimsSet.Builder claimsSetBuilder = new JWTClaimsSet.Builder()
                .subject(userIdString)
                .issueTime(dateBy(currentTime))
                .expirationTime(dateBy(expirationTime));

        SignedJWT signedJWT = new SignedJWT(
                new JWSHeader.Builder(JWSAlgorithm.EdDSA).keyID(jwkId).build(),
                claimsSetBuilder.build()
        );

        signedJWT.sign(jwsSigner);
        return signedJWT.serialize();
    }

    private Date dateBy(LocalDateTime localDateTime) {
        return java.sql.Timestamp.valueOf(localDateTime);
    }
}
