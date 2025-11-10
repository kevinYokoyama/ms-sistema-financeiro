package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class CustomerNameNotAllowedException extends BadRequestException {
    public CustomerNameNotAllowedException() {
        super("ERROR 405: Name not allowed");
    }
}
