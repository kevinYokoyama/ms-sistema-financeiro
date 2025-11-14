package com.example.FinancialSystem.core.exception.Customer;

import org.apache.coyote.BadRequestException;

public class CustomerIdNotFoundException extends BadRequestException {
    public CustomerIdNotFoundException(String id) {
        super("Customer from the id " + id + " not found");
    }
}
