package br.com.bankms.adapters.outbound.persistence.springdata;

import br.com.bankms.application.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataH2CreditCardRepository extends JpaRepository<CreditCard, Long> {
    Optional<CreditCard> findByNumberAndSecurityCodeAndExpirationDateAndCardHolderName(String number,
                                                                                       Integer securityCode,
                                                                                       String expirationDate,
                                                                                       String cardHolderName);
}
