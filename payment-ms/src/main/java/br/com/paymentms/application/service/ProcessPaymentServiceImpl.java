package br.com.paymentms.application.service;

import br.com.paymentms.adapters.outbound.message.producer.Producer;
import br.com.paymentms.application.entity.CreditCard;
import br.com.paymentms.application.ports.service.ProcessPaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProcessPaymentServiceImpl implements ProcessPaymentService {

    private final ObjectMapper mapper;

    private final Producer producer;

    public ProcessPaymentServiceImpl(ObjectMapper mapper, Producer producer) {
        this.mapper = mapper;
        this.producer = producer;
    }

    @Override
    public void processPayment(String payload)  {
        log.info("Starting process payment: {}", payload);
        try {
            var creditCard = mapper.readValue(payload, CreditCard.class);
            log.info("Success: {}", mapper.writeValueAsString(creditCard));
        } catch (JsonProcessingException e) {
            log.error("An error occurred while deserializing. Sending to queue DLQ");

            producer.produceDLQ(payload, e);
        }
    }
}
