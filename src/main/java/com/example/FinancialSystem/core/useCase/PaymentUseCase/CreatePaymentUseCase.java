package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.PaymentMethod;
import com.example.FinancialSystem.core.exception.PaymentMethodNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CreatePaymentUseCase {

    public Payment execute(Payment payment) throws PaymentMethodNotFoundException {

        if (!PaymentMethod.valueOf(String.valueOf(payment.getPaymentMethod())).equals(PaymentMethod.PIX) && !PaymentMethod.valueOf(String.valueOf(payment.getPaymentMethod())).equals(PaymentMethod.CREDIT_CARD) && !PaymentMethod.valueOf(String.valueOf(payment.getPaymentMethod())).equals(PaymentMethod.DEBIT_CARD)) {
            throw new PaymentMethodNotFoundException();
        }

        System.out.print("\nCreating a payment...");
        return Payment.builder()
                .id(payment.getId())
                .amountPaid(payment.getAmountPaid())
                .datePayment(LocalDate.now())
                .paymentMethod(payment.getPaymentMethod())
                .status(payment.getStatus())
                .build();
    }
}
