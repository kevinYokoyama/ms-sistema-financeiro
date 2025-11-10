package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class CustomerStatusNotAllowedException extends BadRequestException {

    public CustomerStatusNotAllowedException() {
        super("Status not Allowed");
    }
}
