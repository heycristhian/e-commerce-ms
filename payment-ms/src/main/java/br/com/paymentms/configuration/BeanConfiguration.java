package br.com.paymentms.configuration;

import br.com.paymentms.PaymentMsApplication;
import br.com.paymentms.adapters.outbound.message.producer.Producer;
import br.com.paymentms.application.ports.service.ProcessPaymentService;
import br.com.paymentms.application.service.ProcessPaymentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = PaymentMsApplication.class)
public class BeanConfiguration {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private Producer producer;

    @Bean
    public ProcessPaymentService processPaymentService() {
        return new ProcessPaymentServiceImpl(mapper, producer);
    }
}
