package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.PaymentMethod;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import com.example.FinancialSystem.core.exception.Payment.PaymentIdNotFoundException;
import com.example.FinancialSystem.core.exception.Payment.PaymentMethodNotFoundException;
import com.example.FinancialSystem.core.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EditPaymentUseCase {

    private final PaymentGateway paymentGateway;

    private final GetByIdPaymentUseCase getByIdPaymentUseCase;

    public Payment execute(String id, Payment payment) throws PaymentMethodNotFoundException, PaymentIdNotFoundException {

        if (!payment.getPaymentMethod().equals(PaymentMethod.PIX) && !payment.getPaymentMethod().equals(PaymentMethod.DEBIT_CARD) && !payment.getPaymentMethod().equals(PaymentMethod.CREDIT_CARD)) {
            log.error("The method must be PIX, debit card or credit card");
            throw new PaymentMethodNotFoundException();
        }
        var saved = getByIdPaymentUseCase.execute(id);

        saved.setStatus(PaymentStatus.EXECUTED);
        System.out.println("\nEditing the amount paid to executed");

        return paymentGateway.save(saved);
    }
}
