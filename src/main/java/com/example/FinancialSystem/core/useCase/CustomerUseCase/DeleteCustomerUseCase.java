package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerUseCase {

    public void execute(String id) {
        System.out.printf("\nDeleting the id %s", id);
    }
}
