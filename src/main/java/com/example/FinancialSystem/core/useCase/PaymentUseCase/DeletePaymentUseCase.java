package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.exception.Payment.PaymentIdNotFoundException;
import com.example.FinancialSystem.core.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletePaymentUseCase {

    private final PaymentGateway paymentGateway;

    public void execute(String id) throws PaymentIdNotFoundException {

        if (paymentGateway.existById(id)) {
            System.out.printf("Id %s removed successfully", id);
            paymentGateway.delete(id);
        }
        throw new PaymentIdNotFoundException(id);
    }
}