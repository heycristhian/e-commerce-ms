package br.com.paymentms.adapters.outbound.message.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface Consumer {
    void consume(ConsumerRecord<String, String> payload);
}
