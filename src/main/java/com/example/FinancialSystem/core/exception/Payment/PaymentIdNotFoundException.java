package com.example.FinancialSystem.core.exception.Payment;

import org.apache.coyote.BadRequestException;

public class PaymentIdNotFoundException extends BadRequestException {
    public PaymentIdNotFoundException(String id) {
        super("Payment from the Id " + id + " not found");
    }
}
