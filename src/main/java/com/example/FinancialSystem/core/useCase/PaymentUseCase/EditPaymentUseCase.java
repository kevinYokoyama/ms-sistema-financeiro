package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.PaymentMethod;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EditPaymentUseCase {

    public Payment execute(Payment status) {
        var payment2 = Payment.builder()
                .id("1")
                .status(PaymentStatus.EXECUTED)
                .paymentMethod(PaymentMethod.CREDIT_CARD)
                .amountPaid(BigDecimal.valueOf(10000))
                .build();
        payment2.setStatus(PaymentStatus.CANCELED);
        System.out.println("\nEditing the amount paid to canceled");
        return payment2;
    }
}
