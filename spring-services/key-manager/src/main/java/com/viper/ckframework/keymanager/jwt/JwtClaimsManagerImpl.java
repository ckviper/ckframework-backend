package com.viper.ckframework.keymanager.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class JwtClaimsManagerImpl implements JwtClaimsManager {

    private static final String USER_ID_CLAIM_KEY = "sub";

    @Override
    public String extractUserId(SecurityContext securityContext) {
        return extractClaim(securityContext, USER_ID_CLAIM_KEY);
    }

    @Override
    public String extractUserId() {
        return extractUserId(SecurityContextHolder.getContext());
    }

    private String extractClaim(SecurityContext securityContext, String claimName) {
        Authentication authentication = securityContext.getAuthentication();

        if (authentication == null) {
            return null;
        }

        if (authentication instanceof JwtAuthenticationToken token) {
            return token.getToken().getClaimAsString(claimName);
        } else {
            // Пользователь не аутентифицирован с помощью JWT
            return null;
        }
    }
}