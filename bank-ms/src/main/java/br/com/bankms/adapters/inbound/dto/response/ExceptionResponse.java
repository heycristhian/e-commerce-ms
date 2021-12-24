package br.com.bankms.adapters.inbound.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionResponse {
    private int code;
    private String status;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FieldExceptionResponse> fields;
}
