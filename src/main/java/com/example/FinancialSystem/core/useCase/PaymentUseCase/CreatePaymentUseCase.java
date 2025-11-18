package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Installment;
import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CreatePaymentUseCase {

    public Payment execute(Payment payment) {

        System.out.print("\nCreating a payment...");
        return Payment.builder()
                .id("001")
                .installment(Installment.builder().id(payment.getInstallment().getId()).build())
                .amountPaid(payment.getAmountPaid())
                .datePayment(LocalDate.now())
                .status(PaymentStatus.EXECUTED)
                .paymentMethod(payment.getPaymentMethod())
                .build();
    }
}
