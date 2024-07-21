package com.portfolio.proposals.operations.repository;

import com.portfolio.proposals.operations.model.entity.ProposalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ProposalRepository extends JpaRepository<ProposalEntity, Long> {

    @Query(value = "SELECT COALESCE(MAX(id), 0) + 1 AS next_id FROM tb_proposal", nativeQuery = true)
    Long getNextSequence();

    Optional<ProposalEntity> findByProposalId(String proposalId);

    default ProposalEntity findByProposalIdOrThrow(String proposalId) {
        return this.findByProposalId(proposalId).orElseThrow(() -> new NullPointerException("Proposta não encontrada"));
    }

}
