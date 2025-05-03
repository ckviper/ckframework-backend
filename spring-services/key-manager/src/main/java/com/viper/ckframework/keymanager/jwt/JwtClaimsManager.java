package com.viper.ckframework.keymanager.jwt;

import org.springframework.security.core.context.SecurityContext;

public interface JwtClaimsManager {
    String USER_ID_CLAIM_KEY = "sub";

    String extractUserId(SecurityContext securityContext);
    String extractUserId();
}
