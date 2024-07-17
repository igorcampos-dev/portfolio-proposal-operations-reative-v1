package com.portfolio.proposals.operations.repository;

import com.portfolio.proposals.operations.model.entity.AccessTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessTokenRepository extends JpaRepository<AccessTokenEntity, String> {
}
