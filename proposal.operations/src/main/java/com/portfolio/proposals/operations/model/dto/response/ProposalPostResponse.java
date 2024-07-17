package com.portfolio.proposals.operations.model.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProposalPostResponse {

    @JsonIgnore
    private HttpStatus status;
    private String message;
    private String proposalId;

    public static ProposalPostResponse responseCreated(String idProposal) {
        return ProposalPostResponse.builder()
                .status(HttpStatus.CREATED)
                .message("Proposa criada com sucesso")
                .proposalId(idProposal)
                .build();
    }

    public static ProposalPostResponse responseBadRequest(String message) {
        return ProposalPostResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(String.format("Houve um erro, causa: %s", message))
                .proposalId(null)
                .build();
    }
}
