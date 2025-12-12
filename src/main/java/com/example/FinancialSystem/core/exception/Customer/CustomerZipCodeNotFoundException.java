package com.example.FinancialSystem.core.exception.Customer;

import org.apache.coyote.BadRequestException;

public class CustomerZipCodeNotFoundException extends BadRequestException {
    public CustomerZipCodeNotFoundException(String zipcode) {
        super("Zipcode " + zipcode + " not found");
    }
}
