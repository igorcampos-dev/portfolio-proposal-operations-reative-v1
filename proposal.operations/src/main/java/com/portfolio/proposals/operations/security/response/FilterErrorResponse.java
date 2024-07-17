package com.portfolio.proposals.operations.security.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.portfolio.proposals.operations.model.dto.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Data
@AllArgsConstructor
public class FilterErrorResponse {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows(IOException.class)
    public static void getError(HttpServletResponse response, Exception e, HttpServletRequest request){
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.writeValue(
                response.getWriter(),
                ErrorResponse.responseError(
                        e.getMessage(),
                        request.getServletPath(),
                        HttpStatus.UNAUTHORIZED.value()
                )
        );
    }

}