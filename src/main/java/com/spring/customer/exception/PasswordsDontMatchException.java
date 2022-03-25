package com.spring.customer.exception;



public class PasswordsDontMatchException extends RuntimeException {

    public PasswordsDontMatchException(String message) {
        super(message);
    }
}
