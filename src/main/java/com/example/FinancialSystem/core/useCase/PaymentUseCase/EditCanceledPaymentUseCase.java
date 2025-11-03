package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.PaymentMethod;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;

import java.math.BigDecimal;

public class EditCanceledPaymentUseCase {
    public Payment execute(PaymentStatus status) {
        var payment2 = Payment.builder()
                .id("1")
                .status(PaymentStatus.EXECUTED)
                .paymentMethod(PaymentMethod.CREDIT_CARD)
                .amountPaid(BigDecimal.valueOf(10000))
                .build();
        System.out.println(payment2);
        System.out.printf("\nEditing the status to %s", status);
        payment2.setStatus(PaymentStatus.CANCELED);
        return payment2;
    }
}
