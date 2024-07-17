package com.portfolio.proposals.operations.service;

import com.portfolio.proposals.operations.model.dto.request.ProposalRequest;
import com.portfolio.proposals.operations.model.dto.response.ProposalGetResponse;
import com.portfolio.proposals.operations.model.dto.response.ProposalPostResponse;
import com.portfolio.proposals.operations.model.entity.ProposalEntity;
import com.portfolio.proposals.operations.repository.ProposalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class ProposalServiceImpl implements ProposalService {

    private final ProposalRepository proposalRepository;

    @Override
    public ProposalPostResponse save(ProposalRequest proposalRequest) {

        try {
            var idProposal = this.saveProposal(proposalRequest);
            return ProposalPostResponse.responseCreated(idProposal);
        } catch (Exception e) {
            return ProposalPostResponse.responseBadRequest(e.getMessage());
        }

    }

    @Override
    public ProposalGetResponse getProposalById(String proposalId) {
        ProposalEntity proposalEntity = this.proposalRepository.findByProposalIdOrThrow(proposalId);
        return proposalEntity.toDtoGet();
    }

    private String getIdProposal(){
        Long nextIdSequence = this.proposalRepository.getNextSequence();
        return String.format("PRPST-%s", nextIdSequence);
    }

    private synchronized String saveProposal(ProposalRequest proposalRequest){
        String idProposal = getIdProposal();
        proposalRequest.setProposalId(idProposal);
        proposalRepository.save(proposalRequest.dtoToEntity());
        return idProposal;
    }

}
