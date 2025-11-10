package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class PaymentMethodNotFoundException extends BadRequestException {
    public PaymentMethodNotFoundException() {
        super("ERROR 404: Payment not found");
    }
}
