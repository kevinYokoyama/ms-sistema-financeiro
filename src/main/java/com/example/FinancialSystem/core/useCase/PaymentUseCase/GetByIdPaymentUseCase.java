package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.exception.Payment.PaymentIdNotFoundException;
import com.example.FinancialSystem.core.gateway.GenericGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetByIdPaymentUseCase {

    private final GenericGateway<Payment> paymentGateway;

    public Payment execute(String id) throws PaymentIdNotFoundException {

        if (!paymentGateway.existById(id)) {
            log.error("Id not found");
            throw new PaymentIdNotFoundException(id);
        }
        return paymentGateway.getById(id);
    }
}