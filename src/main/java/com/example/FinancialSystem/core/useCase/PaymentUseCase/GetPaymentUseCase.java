package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Payment;

import java.util.List;

public class GetPaymentUseCase {
    public List<Payment> execute(String id) {
        System.out.printf("\nSearching for the id: %s", id);
        return List.of();
    }
}
