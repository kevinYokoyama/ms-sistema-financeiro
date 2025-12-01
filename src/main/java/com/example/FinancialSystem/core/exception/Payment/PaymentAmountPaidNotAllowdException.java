package com.example.FinancialSystem.core.exception.Payment;

import org.apache.coyote.BadRequestException;

public class PaymentAmountPaidNotAllowdException extends BadRequestException {
    public PaymentAmountPaidNotAllowdException() {
        super("Amount paid needs to be more than 0");
    }
}
