package com.portfolio.proposals.operations.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponse(

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime timestamp,
        int status,
        String error,
        String path

) {

    public static ErrorResponse responseError(String errorMessage, String servletPath, int statusValue){
        return ErrorResponse.builder()
                .error(errorMessage)
                .path(servletPath)
                .timestamp(LocalDateTime.now())
                .status(statusValue)
                .build();
    }
}
