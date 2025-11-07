package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class CustomerNameNotAllowed extends BadRequestException {
    public CustomerNameNotAllowed() {
        super("ERROR 405: Name not allowed");
    }
}
