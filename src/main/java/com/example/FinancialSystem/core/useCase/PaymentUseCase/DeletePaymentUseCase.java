package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import org.springframework.stereotype.Component;

@Component
public class DeletePaymentUseCase {

    public void execute(String id) {
        System.out.printf("\nDeleting the id %s", id);
    }
}
