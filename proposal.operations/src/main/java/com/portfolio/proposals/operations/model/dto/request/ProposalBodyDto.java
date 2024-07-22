package com.portfolio.proposals.operations.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProposalBodyDto {

    @Valid
    private ContractorDto contractor;
    @Valid
    private ContracteeDto contractee;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @NotNull(message = "O campo `contract_description` não pode ser nulo")
    private String contract_description;
    @NotNull(message = "O campo `value` não pode ser nulo")
    private BigDecimal value;
    @NotNull(message = "O campo `term` não pode ser nulo")
    private String term;

}
