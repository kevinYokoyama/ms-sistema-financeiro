package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class CustomerNameNotAllowedException extends BadRequestException {
    public CustomerNameNotAllowedException() {
        super("Name not allowed");
    }
}
