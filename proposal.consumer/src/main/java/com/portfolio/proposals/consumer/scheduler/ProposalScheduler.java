package com.portfolio.proposals.consumer.scheduler;

import com.portfolio.proposals.consumer.service.ProposalService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class ProposalScheduler {

    private final ProposalService proposalService;

    @PostConstruct
    public void scheduleProposalProcessing() {
        Flux.interval(Duration.ofSeconds(10))
            .flatMap(tick -> Mono.fromRunnable(proposalService::processProposal))
            .subscribe();
    }

}
