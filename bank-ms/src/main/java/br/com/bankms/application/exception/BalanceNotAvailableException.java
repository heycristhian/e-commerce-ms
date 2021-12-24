package br.com.bankms.application.exception;

public class BalanceNotAvailableException extends RuntimeException {
    public BalanceNotAvailableException(String msg) {
        super(msg);
    }
}
