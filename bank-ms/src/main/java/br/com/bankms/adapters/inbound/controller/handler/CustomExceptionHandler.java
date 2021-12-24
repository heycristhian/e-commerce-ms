package br.com.bankms.adapters.inbound.controller.handler;

import br.com.bankms.adapters.inbound.dto.response.ExceptionResponse;
import br.com.bankms.adapters.inbound.dto.response.FieldExceptionResponse;
import br.com.bankms.application.exception.BalanceNotAvailableException;
import br.com.bankms.application.exception.CreditCardNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var response = ExceptionResponse.builder()
                .code(status.value())
                .status(status.getReasonPhrase())
                .message("There are fields with errors")
                .fields(getFieldsExceptionResponse(ex))
                .build();
        log.error("Field validation error: {}", response);
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(CreditCardNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCreditCardNotFoundException(CreditCardNotFoundException e) {
        var httpStatus = HttpStatus.NOT_FOUND;
        return handle(httpStatus, e);
    }

    @ExceptionHandler(BalanceNotAvailableException.class)
    public ResponseEntity<ExceptionResponse> handleBalanceNotAvailableException(BalanceNotAvailableException e) {
        var httpStatus = HttpStatus.NOT_ACCEPTABLE;
        return handle(httpStatus, e);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return handle(httpStatus, e);
    }

    private ResponseEntity<ExceptionResponse> handle(HttpStatus httpStatus, Exception e) {
        var response = ExceptionResponse.builder()
                .code(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .message(e.getLocalizedMessage())
                .build();

        log.error("Exception: {}", response);
        return ResponseEntity.status(httpStatus).body(response);
    }

    private List<FieldExceptionResponse> getFieldsExceptionResponse(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> FieldExceptionResponse.builder()
                        .message(error.getDefaultMessage())
                        .field(error.getField())
                        .parameter(error.getRejectedValue())
                        .build())
                .collect(Collectors.toList());
    }
}
