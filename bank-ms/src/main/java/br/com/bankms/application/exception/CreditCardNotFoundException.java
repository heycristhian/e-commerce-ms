package br.com.bankms.application.exception;

public class CreditCardNotFoundException extends RuntimeException {
    public CreditCardNotFoundException(String msg) {
        super(msg);
    }
}
