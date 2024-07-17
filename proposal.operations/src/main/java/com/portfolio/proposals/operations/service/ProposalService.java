package com.portfolio.proposals.operations.service;

import com.portfolio.proposals.operations.model.dto.request.ProposalRequest;
import com.portfolio.proposals.operations.model.dto.response.ProposalGetResponse;
import com.portfolio.proposals.operations.model.dto.response.ProposalPostResponse;

public interface ProposalService {
    ProposalPostResponse save(ProposalRequest proposalRequest);
    ProposalGetResponse getProposalById(String proposalId);
}
