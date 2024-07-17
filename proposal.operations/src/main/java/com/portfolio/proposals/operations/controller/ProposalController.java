package com.portfolio.proposals.operations.controller;

import com.portfolio.proposals.operations.model.dto.request.ProposalRequest;
import com.portfolio.proposals.operations.model.dto.response.ProposalGetResponse;
import com.portfolio.proposals.operations.model.dto.response.ProposalPostResponse;
import com.portfolio.proposals.operations.service.ProposalService;
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
public class ProposalController {

    public static final String PATH = "/v1/proposals";

    private final ProposalService proposalService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ProposalPostResponse> saveProposal(@RequestBody @Valid ProposalRequest proposalRequest){
        log.info("Starting the process of saving a proposal...");
        var response = proposalService.save(proposalRequest);
        log.info("Proposal Save Process Completed Successfully.");
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{proposalId}")
    public ResponseEntity<ProposalGetResponse> getProposalById(@PathVariable("proposalId") String proposalId){
        log.info("starting the process of searching for a proposal by proposalId...");
        var response = proposalService.getProposalById(proposalId);
        log.info("proposal search process by proposalId completed successfully.");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
