package br.com.bankms.adapters.inbound.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FieldExceptionResponse {

    private final String field;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Object parameter;
}