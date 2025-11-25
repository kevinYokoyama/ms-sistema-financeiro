package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.Installment;
import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.PaymentMethod;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import com.example.FinancialSystem.core.exception.Payment.PaymentMethodNotFoundException;
import com.example.FinancialSystem.core.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditPaymentUseCase {

    private final PaymentGateway paymentGateway;

    public Payment execute(Payment payment) throws PaymentMethodNotFoundException {

        if (!payment.getPaymentMethod().equals(PaymentMethod.PIX) && !payment.getPaymentMethod().equals(PaymentMethod.DEBIT_CARD) && !payment.getPaymentMethod().equals(PaymentMethod.CREDIT_CARD)) {
            throw new PaymentMethodNotFoundException();
        }

        Payment editedPayment = paymentGateway.getById(payment.getId());
        editedPayment.setStatus(PaymentStatus.EXECUTED);
        System.out.println("\nEditing the amount paid to executed");

        return editedPayment;
    }
}
