package com.portfolio.proposals.operations.model.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portfolio.proposals.operations.model.entity.ProposalEntity;
import com.portfolio.proposals.operations.model.entity.fields.Status;
import jakarta.validation.Valid;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProposalRequest {

    @Valid
    private ProposalBodyDto proposal;

    @JsonIgnore
    private String proposalId;

    public ProposalEntity dtoToEntity(){
        return ProposalEntity.builder()
                .proposalId(this.getProposalId())
                .date(this.getProposal().getDate())
                .nameContractor(this.getProposal().getContractor().getName())
                .cnpjContractor(this.getProposal().getContractor().getCnpj())
                .addressContractor(this.getProposal().getContractor().getAddress())
                .phoneContractor(this.getProposal().getContractor().getPhone())
                .emailContractor(this.getProposal().getContractor().getEmail())
                .nameContracted(this.getProposal().getContractor().getEmail())
                .emailContracted(this.getProposal().getContractee().getName())
                .cnpjContracted(this.getProposal().getContractee().getCnpj())
                .addressContracted(this.getProposal().getContractee().getAddress())
                .phoneContracted(this.getProposal().getContractee().getPhone())
                .emailContracted(this.getProposal().getContractee().getEmail())
                .contractDescription(this.getProposal().getContract_description())
                .value(this.getProposal().getValue())
                .term(this.getProposal().getTerm())
                .status(Status.PROCESS)
                .build();
    }

}