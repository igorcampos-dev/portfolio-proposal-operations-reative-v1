package com.portfolio.proposals.operations.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContracteeDto {

    @NotNull(message = "o campo ´cnpj` não pode ser nulo")
    @CNPJ(message = "O campo `cnpj` é inválido, por favor, insira um cnpj válido")
    private String cnpj;

    @NotNull(message = "o campo ´name` não pode ser nulo")
    private String name;

    @NotNull(message = "o campo `address` não pode ser nulo")
    private String address;

    @NotNull(message = "O campo `phone` não pode ser nulo")
    @Pattern(
            regexp = "^\\+\\d{2}\\s\\(\\d{2}\\)\\s\\d{4}-\\d{4}$",
            message = "Formato de número inválido, siga o padrão: +00 (00) 0000-0000"
    )
    private String phone;

    @Email(message = "Email inválido, por favor, insira um email adequado")
    @NotNull(message = "O campo `email` não pode ser nulo")
    private String email;


}
