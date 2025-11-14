package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class PaymentMethodNotFoundException extends BadRequestException {
    public PaymentMethodNotFoundException() {
        super("Payment method not found. It needs to be PIX, CREDIT_CARD or DEBIT_CARD)");
    }
}
