package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;

import java.util.List;

public class DeleteCustomerUseCase {
    public List<Customer> execute(String id) {
        System.out.printf("\nDeleting the id %s", id);
        return List.of();
    }
}
