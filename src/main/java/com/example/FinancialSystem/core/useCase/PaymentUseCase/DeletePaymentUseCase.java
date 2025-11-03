package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Payment;
import org.springframework.stereotype.Component;

@Component
public class DeletePaymentUseCase {

    public Payment execute(String id) {
        System.out.printf("\nDeleting the id %s", id);
        return null;
    }
}
