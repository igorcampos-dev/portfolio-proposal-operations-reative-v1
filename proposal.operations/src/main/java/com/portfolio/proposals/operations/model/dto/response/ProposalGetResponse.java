package com.portfolio.proposals.operations.model.dto.response;

import com.portfolio.proposals.operations.model.entity.fields.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProposalGetResponse {

    private String proposalId;
    private LocalDate date;
    private String nameContractor;
    private String cnpjContractor;
    private String addressContractor;
    private String phoneContractor;
    private String emailContractor;
    private String nameContracted;
    private String cnpjContracted;
    private String addressContracted;
    private String phoneContracted;
    private String emailContracted;
    private String contractDescription;
    private BigDecimal value;
    private String term;
    private Status status;

}
