package com.portfolio.proposals.consumer.scheduler;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;

@Service
@SuppressWarnings("unused")
public class ProposalScheduler {

    @PostConstruct
    public void scheduleProposalProcessing() {
        Flux.interval(Duration.ofSeconds(10))
                .flatMap(tick -> Mono.fromRunnable(this::processProposals))
                .subscribe();
    }

    private void processProposals() {
        System.out.println("Funcionou!");
    }
}
