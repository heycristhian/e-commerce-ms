package br.com.paymentms.adapters.outbound.message.producer;

public interface Producer {
    void produceDLQ(String message, Exception e);
}
