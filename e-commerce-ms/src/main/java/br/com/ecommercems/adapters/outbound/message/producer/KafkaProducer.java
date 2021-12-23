package br.com.ecommercems.adapters.outbound.message.producer;

import br.com.ecommercems.application.entity.CreditCard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@NoArgsConstructor
public class KafkaProducer {

    @Value("${topic.name.payment}")
    private String topicName;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(CreditCard message) throws JsonProcessingException {
        log.info("Sending message on kafka: {}", message);
        kafkaTemplate.send(topicName, mapper.writeValueAsString(message));
    }
}