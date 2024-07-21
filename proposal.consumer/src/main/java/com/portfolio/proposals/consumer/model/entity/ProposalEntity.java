package com.portfolio.proposals.consumer.model.entity;

import com.portfolio.proposals.consumer.model.entity.fields.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PROPOSAL")
public class ProposalEntity {

    @Id
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
    private String status;
}
