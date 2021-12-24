package br.com.bankms.application.service;

import br.com.bankms.application.entity.CreditCard;
import br.com.bankms.application.exception.BalanceNotAvailableException;
import br.com.bankms.application.exception.CreditCardNotFoundException;
import br.com.bankms.application.ports.repository.CreditCardRepository;
import br.com.bankms.application.ports.service.CreditCardService;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository repository;

    public CreditCardServiceImpl(CreditCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public void buy(CreditCard creditCard, BigDecimal value) {
        creditCard = repository.findByNumberAndSecurityCodeAndExpirationDateAndCardHolderName(creditCard.getNumber(),
                        creditCard.getSecurityCode(),
                        creditCard.getExpirationDate(),
                        creditCard.getCardHolderName())
                .orElseThrow(() -> new CreditCardNotFoundException("Credit card not found"));

        if (creditCard.getBalance().compareTo(value) < 0) {
            throw new BalanceNotAvailableException("There is no balance available for purchase");
        }

        creditCard.setBalance(creditCard.getBalance().subtract(value));
        repository.save(creditCard);
        log.info("Purchase process executed successfully");
    }
}
