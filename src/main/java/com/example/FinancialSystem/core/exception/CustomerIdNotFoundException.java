package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class CustomerIdNotFoundException extends BadRequestException {
    public CustomerIdNotFoundException() {
        super("Id not found");
    }
}
