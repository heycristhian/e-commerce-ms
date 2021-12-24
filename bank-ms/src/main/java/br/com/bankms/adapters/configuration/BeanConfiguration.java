package br.com.bankms.adapters.configuration;

import br.com.bankms.BankMsApplication;
import br.com.bankms.adapters.mapper.CreditCardMapper;
import br.com.bankms.application.ports.repository.CreditCardRepository;
import br.com.bankms.application.ports.service.CreditCardService;
import br.com.bankms.application.service.CreditCardServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = BankMsApplication.class)
public class BeanConfiguration {

    @Bean
    public CreditCardService creditCardService(CreditCardRepository repository) {
        return new CreditCardServiceImpl(repository);
    }

}
