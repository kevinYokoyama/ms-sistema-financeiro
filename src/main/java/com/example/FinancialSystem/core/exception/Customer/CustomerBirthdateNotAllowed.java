package com.example.FinancialSystem.core.exception.Customer;

import org.apache.coyote.BadRequestException;

public class CustomerBirthdateNotAllowed extends BadRequestException {
    public CustomerBirthdateNotAllowed() {
        super("Birthdate not allowed, you need to be more than 18 years old");
    }
}
