package com.demo.springbootjpadocker.api.exception;


public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(long id) {
        super(String.format("Customer with id %d not found.", id));
    }
}
