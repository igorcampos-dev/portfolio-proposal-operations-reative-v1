package com.portfolio.proposals.operations.model.entity;

import com.portfolio.proposals.operations.model.dto.response.ProposalGetResponse;
import com.portfolio.proposals.operations.model.entity.fields.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PROPOSAL")
public class ProposalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private String value;
    private String term;

    @Enumerated(EnumType.STRING)
    private Status status;

    public ProposalGetResponse toDtoGet(){
        return ProposalGetResponse.builder()
                .proposalId(this.getProposalId())
                .date(this.getDate())
                .nameContractor(this.getNameContractor())
                .cnpjContractor(this.getCnpjContractor())
                .addressContractor(this.getAddressContractor())
                .phoneContractor(this.getPhoneContractor())
                .emailContractor(this.getEmailContractor())
                .nameContracted(this.getNameContracted())
                .cnpjContracted(this.getCnpjContracted())
                .addressContracted(this.getAddressContracted())
                .phoneContracted(this.getPhoneContracted())
                .emailContracted(this.getEmailContracted())
                .contractDescription(this.getContractDescription())
                .value(this.getValue())
                .term(this.getTerm())
                .status(this.getStatus())
                .build();
    }

}
