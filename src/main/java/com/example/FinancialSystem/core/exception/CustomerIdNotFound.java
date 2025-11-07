package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class CustomerIdNotFound extends BadRequestException {
    public CustomerIdNotFound() {
        super("ERROR 404: Id not found");
    }
}
