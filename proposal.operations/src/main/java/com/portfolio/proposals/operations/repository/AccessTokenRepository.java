package com.portfolio.proposals.operations.repository;

import com.portfolio.proposals.operations.model.entity.AccessTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessTokenEntity, String> {
}
