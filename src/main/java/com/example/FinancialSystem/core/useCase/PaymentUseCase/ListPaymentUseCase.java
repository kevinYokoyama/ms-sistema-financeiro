package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ListPaymentUseCase {

    private final PaymentGateway paymentGateway;

    public Page<Payment> execute(Pageable pageable) {
        return paymentGateway.findAll(pageable);
    }
}
