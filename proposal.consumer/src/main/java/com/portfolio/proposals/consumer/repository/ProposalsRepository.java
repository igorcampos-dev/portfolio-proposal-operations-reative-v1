package com.portfolio.proposals.consumer.repository;

import com.portfolio.proposals.consumer.model.entity.ProposalEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProposalsRepository extends ReactiveCrudRepository<ProposalEntity, Long> {

    Flux<ProposalEntity> findByStatus(String status);

    default Flux<ProposalEntity> findByStatusOrNull(String status) {
        return this.findByStatus(status).switchIfEmpty(Flux.empty());
    }
}
