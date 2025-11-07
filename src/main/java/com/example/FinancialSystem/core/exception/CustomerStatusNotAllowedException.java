package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class CustomerStatusNotAllowedException extends BadRequestException {

    public CustomerStatusNotAllowedException() {
        super("ERROR 405: Status not Allowed");
    }
}
