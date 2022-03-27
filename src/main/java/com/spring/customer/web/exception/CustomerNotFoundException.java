package com.spring.customer.web.exception;



public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Could not find customer " + id);
    }
}
