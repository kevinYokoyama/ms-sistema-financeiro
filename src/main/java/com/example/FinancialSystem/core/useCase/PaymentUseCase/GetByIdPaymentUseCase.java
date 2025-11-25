package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.exception.Payment.PaymentIdNotFoundException;
import com.example.FinancialSystem.core.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByIdPaymentUseCase {

    private final PaymentGateway paymentGateway;

    public Payment execute(String id) throws PaymentIdNotFoundException {

        if (paymentGateway.existById(id)) {
            return paymentGateway.getById(id);
        }
        throw new PaymentIdNotFoundException(id);
    }
}