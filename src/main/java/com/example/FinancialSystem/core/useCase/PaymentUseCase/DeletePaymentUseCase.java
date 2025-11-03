package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Payment;

import java.util.List;

public class DeletePaymentUseCase {
    public List<Payment> execute(String id) {
        System.out.printf("\nDeleting the id %s", id);
        return List.of();
    }
}
