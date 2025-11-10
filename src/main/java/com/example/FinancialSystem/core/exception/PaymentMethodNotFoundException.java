package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class PaymentMethodNotFoundException extends BadRequestException {
    public PaymentMethodNotFoundException() {
        super("Payment not found");
    }
}
