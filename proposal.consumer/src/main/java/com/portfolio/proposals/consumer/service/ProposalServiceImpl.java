package com.portfolio.proposals.consumer.service;

import com.portfolio.proposals.consumer.exception.ProposalProcessingException;
import com.portfolio.proposals.consumer.model.entity.ProposalEntity;
import com.portfolio.proposals.consumer.model.entity.fields.Status;
import com.portfolio.proposals.consumer.repository.ProposalsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class ProposalServiceImpl implements ProposalService {

    private final ProposalsRepository proposalsRepository;

    @Override
    public void processProposal() {
        log.info("Iniciou o processo das propostas");

        Flux<ProposalEntity> proposals = proposalsRepository.findByStatusOrNull(Status.PROCESS.toString());

        proposals.collectList()
                .doOnNext(this::execute)
                .doOnError(error -> log.error("Erro ao processar as propostas", error))
                .subscribe();
    }

    private void execute(List<ProposalEntity> proposalList){
        if (!proposalList.isEmpty()) {
            proposalList.forEach(this::print);
        }

    }

    private void print(ProposalEntity proposal){
        try {
            log.info("Iniciando o processo de operação da proposta...");
            log.info("O conteúdo da proposta é: {}", proposal);

            proposal.setStatus(Status.FINISHED.toString());

            proposalsRepository.save(proposal)
                    .doOnError(error -> {
                        throw new ProposalProcessingException(String.format("Erro ao atualizar proposta no banco de dados: %s", error.getMessage()));
                    })
                    .subscribe();

            log.info("Processo de busca finalizado com sucesso.");
        } catch (Exception e) {
            log.error("Houve um erro ao processar a proposta, causa: {}", e.getMessage());

            proposal.setStatus(Status.ERROR.toString());
            proposalsRepository.save(proposal).subscribe();
        }

    }


}
