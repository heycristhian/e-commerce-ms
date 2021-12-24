package br.com.bankms.adapters.outbound.persistence.repository;

import br.com.bankms.adapters.outbound.persistence.springdata.SpringDataH2CreditCardRepository;
import br.com.bankms.application.entity.CreditCard;
import br.com.bankms.application.ports.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class H2CreditCardRepository implements CreditCardRepository {

    @Autowired
    private SpringDataH2CreditCardRepository repository;

    @Override
    public Optional<CreditCard> findByNumberAndSecurityCodeAndExpirationDateAndCardHolderName(String number, Integer securityCode, String expirationDate, String cardHolderName) {
        return repository.findByNumberAndSecurityCodeAndExpirationDateAndCardHolderName(number,
                securityCode,
                expirationDate,
                cardHolderName);
    }

    @Override
    public CreditCard save(CreditCard creditCard) {
        return repository.save(creditCard);
    }
}
