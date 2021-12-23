package br.com.ecommercems.configuration;

import br.com.ecommercems.adapters.outbound.message.producer.KafkaProducer;
import br.com.ecommercems.application.entity.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartConfiguration implements CommandLineRunner {

    @Autowired
    private KafkaProducer producer;

    @Override
    public void run(String... args) throws Exception {
        var creditCard = CreditCard.builder()
                .cardHolderName("Cristhian Nunes Dias")
                .number("4521452145214521")
                .expirationDate("09/29")
                .securityCode(586)
                .build();
        producer.send(creditCard);
    }
}
