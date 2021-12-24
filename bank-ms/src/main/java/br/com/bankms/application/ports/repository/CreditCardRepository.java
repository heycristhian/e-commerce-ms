package br.com.bankms.application.ports.repository;

import br.com.bankms.application.entity.CreditCard;

import java.util.Optional;

public interface CreditCardRepository {
    Optional<CreditCard> findByNumberAndSecurityCodeAndExpirationDateAndCardHolderName(String number,
                                                                           Integer securityCode,
                                                                           String expirationDate,
                                                                           String cardHolderName);

    CreditCard save(CreditCard creditCard);
}
