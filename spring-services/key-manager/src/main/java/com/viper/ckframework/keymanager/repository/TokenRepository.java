package com.viper.ckframework.keymanager.repository;

import com.viper.ckframework.keymanager.entity.ApiTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TokenRepository extends JpaRepository<ApiTokenEntity, Long> {
    List<ApiTokenEntity> findAllByUserId(String userId);
}
