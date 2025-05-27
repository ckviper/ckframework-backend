package repository;

import entity.TokenUsageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenUsageRepository extends JpaRepository<TokenUsageEntity, Long> {
}

