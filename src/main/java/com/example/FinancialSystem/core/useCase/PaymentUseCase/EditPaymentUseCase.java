package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Installment;
import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.PaymentMethod;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import com.example.FinancialSystem.core.exception.Payment.PaymentMethodNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class EditPaymentUseCase {

    public Payment execute(Payment payment) throws PaymentMethodNotFoundException {

        if (!payment.getPaymentMethod().equals(PaymentMethod.PIX) && !payment.getPaymentMethod().equals(PaymentMethod.DEBIT_CARD) && !payment.getPaymentMethod().equals(PaymentMethod.CREDIT_CARD)) {
            throw new PaymentMethodNotFoundException();
        }

        var payment2 = Payment.builder()
                .id("14")
                .status(PaymentStatus.ERROR)
                .amountPaid(payment.getAmountPaid())
                .paymentMethod(payment.getPaymentMethod())
                .installment(Installment.builder().id(payment.getInstallment().getId()).build())
                .build();

        payment2.setStatus(PaymentStatus.EXECUTED);

        System.out.println("\nEditing the amount paid to executed");
        return payment2;
    }
}
