package com.portfolio.proposals.operations.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Api de operações de propostas",
        description = "Esta api possui finalidade de salvar e buscar propostas",
        version = "1.0",
        contact = @Contact(
                name = "Igor de campos",
                email = "igorccampos8@gmail.com",
                url = "https://igorcampos-dev.github.io/"
        )
))
@SecurityScheme(
        name = "API Key Authentication",
        type = SecuritySchemeType.APIKEY,
        in = SecuritySchemeIn.HEADER,
        paramName = "x-api-key"
)
@SuppressWarnings("unused")
public class SwaggerConfig {}