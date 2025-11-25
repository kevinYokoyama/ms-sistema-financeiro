package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Installment;
import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import com.example.FinancialSystem.core.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CreatePaymentUseCase {

    private final PaymentGateway paymentGateway;

    public Payment execute(Payment payment) {

        var installment = Installment.builder().id(payment.getInstallment().getId()).build();

        payment.setAmountPaid(payment.getAmountPaid());
        payment.setDatePayment(LocalDate.now());
        payment.setPaymentMethod(payment.getPaymentMethod());
        payment.setInstallment(installment);
        payment.setStatus(PaymentStatus.EXECUTED);
        System.out.print("\nCreating a payment...");

        return paymentGateway.save(payment);
    }
}
