package com.portfolio.proposals.operations.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractorDto {

    @NotNull(message = "o campo ´cnpj` não pode ser nulo")
    @CNPJ(message = "O campo `cnpj` é inválido, por favor, insira um cnpj válido")
    private String cnpj;
    @NotNull(message = "o campo ´name` não pode ser nulo")
    private String name;
    @NotNull(message = "o campo `address` não pode ser nulo")
    private String address;
    @NotNull(message = "O campo `phone` não pode ser nulo")
    private String phone;
    @NotNull(message = "O campo `email` não pode ser nulo")
    @Email(message = "Email inválido, por favor, insira um email adequado")
    private String email;

}
