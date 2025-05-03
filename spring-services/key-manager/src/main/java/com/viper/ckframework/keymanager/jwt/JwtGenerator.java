package com.viper.ckframework.keymanager.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtGenerator {
    String generate();
}
