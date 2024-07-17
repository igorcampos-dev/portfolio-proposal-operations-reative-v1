package com.portfolio.proposals.operations.controller;

import com.portfolio.proposals.operations.model.dto.request.ProposalRequest;
import com.portfolio.proposals.operations.model.dto.response.ProposalGetResponse;
import com.portfolio.proposals.operations.model.dto.response.ProposalPostResponse;
import com.portfolio.proposals.operations.service.ProposalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@SuppressWarnings("unused")
@RequestMapping(ProposalController.PATH)
@Tag(name = "Processar propostas", description = "Controlador para operações de salvar e buscar propostas")
public class ProposalController {

    public static final String PATH = "/v1/proposals";

    private final ProposalService proposalService;

    @SecurityRequirement(name = "API Key Authentication")
    @ApiResponse(description = "Salvar proposta", responseCode = "201")
    @Operation(summary = "Salva proposta no banco de dados", description = """
            # Retorna uma mensagem de sucesso ou erro
            ---
           
            """)
    @PostMapping(consumes = "application/json")
    public ResponseEntity<ProposalPostResponse> saveProposal(@RequestBody @Valid ProposalRequest proposalRequest){
        log.info("Starting the process of saving a proposal...");
        var response = proposalService.save(proposalRequest);
        log.info("Proposal Save Process Completed Successfully.");
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @SecurityRequirement(name = "API Key Authentication")
    @ApiResponse(description = "Buscar propostas", responseCode = "200")
    @Operation(summary = "Busca proposta no banco de dados", description = """
            # Retorna uma proposta ou erro de proposta não encontrada
            ---
           
            """)
    @GetMapping("/{proposalId}")
    public ResponseEntity<ProposalGetResponse> getProposalById(@PathVariable("proposalId") String proposalId){
        log.info("starting the process of searching for a proposal by proposalId...");
        var response = proposalService.getProposalById(proposalId);
        log.info("proposal search process by proposalId completed successfully.");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
