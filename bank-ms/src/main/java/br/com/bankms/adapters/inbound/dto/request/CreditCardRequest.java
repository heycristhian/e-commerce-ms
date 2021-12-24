package br.com.bankms.adapters.inbound.dto.request;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditCardRequest {

    @NotBlank(message = "Number must not be empty or null")
    private String number;

    @NotNull(message = "SecurityCode must not be null")
    @Positive(message = "SecurityCode must be positive")
    private Integer securityCode;

    @NotBlank(message = "ExpirationDate must not be empty or null")
    private String expirationDate;

    @NotBlank(message = "Number must not be empty or null")
    private String cardHolderName;
}
