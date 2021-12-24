package br.com.bankms.application.ports.service;

import br.com.bankms.application.entity.CreditCard;

import java.math.BigDecimal;

public interface CreditCardService {
    void buy(CreditCard creditCard, BigDecimal value);
}
