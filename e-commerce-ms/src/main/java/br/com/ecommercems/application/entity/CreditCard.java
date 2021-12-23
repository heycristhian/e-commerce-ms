package br.com.ecommercems.application.entity;

import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class CreditCard {

    private String number;
    private Integer securityCode;
    private String expirationDate;
    private String cardHolderName;

}
