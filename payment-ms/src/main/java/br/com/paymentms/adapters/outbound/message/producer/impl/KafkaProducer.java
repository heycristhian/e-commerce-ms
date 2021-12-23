package br.com.paymentms.adapters.outbound.message.producer.impl;

import br.com.paymentms.adapters.outbound.message.producer.Producer;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@NoArgsConstructor
public class KafkaProducer implements Producer {

    @Value("${topic.name.payment.dlq}")
    private String topicNameDLQ;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void produceDLQ(String message, Exception e) {
        log.info("Sending message on kafka DLQ ({}): {}", topicNameDLQ, message);
        message = message + " -> Error: " + e.getLocalizedMessage();
        kafkaTemplate.send(topicNameDLQ, message);
    }
}
