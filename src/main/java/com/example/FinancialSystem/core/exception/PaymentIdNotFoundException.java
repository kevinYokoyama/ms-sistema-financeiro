package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class PaymentIdNotFoundException extends BadRequestException {
    public PaymentIdNotFoundException() {
        super("Id not found");
    }
}
