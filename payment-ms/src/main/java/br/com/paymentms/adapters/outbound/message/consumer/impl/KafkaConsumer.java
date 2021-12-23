package br.com.paymentms.adapters.outbound.message.consumer.impl;

import br.com.paymentms.adapters.outbound.message.consumer.Consumer;
import br.com.paymentms.application.ports.service.ProcessPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer implements Consumer {

    @Autowired
    private ProcessPaymentService service;

    @Override
    @KafkaListener(topics = "${topic.name.payment}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Payload received on topic 'PAYMENT': {}", payload.value());
        service.processPayment(payload.value());
    }
}
