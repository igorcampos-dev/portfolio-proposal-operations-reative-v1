package com.portfolio.proposals.operations.exception;

import com.portfolio.proposals.operations.model.dto.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.format.DateTimeParseException;

@RestControllerAdvice
@SuppressWarnings("unused")
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        FieldError fieldError = ex.getBindingResult().getFieldErrors().get(0);
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        String message = String.format("Erro no campo %s, causa: %s", fieldError.getField(), fieldError.getDefaultMessage());
        return ResponseEntity.status(badRequest)
                             .body(ErrorResponse
                                     .responseError(message, request.getServletPath(), badRequest.value())
                             );
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ErrorResponse> handleDateTimeParseException(HttpServletRequest request) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        String errorMessage = "Formato de data inválido. Use o formato 'yyyy-MM-dd'.";
        return ResponseEntity.status(badRequest).body(ErrorResponse.responseError(errorMessage, request.getServletPath(), badRequest.value()));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex, HttpServletRequest request) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(notFound).body(ErrorResponse.responseError(ex.getMessage(), request.getServletPath(), notFound.value()));
    }

}
