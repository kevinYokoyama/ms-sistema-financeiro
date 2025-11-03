package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerUseCase {

    public Customer execute(String id) {
        System.out.printf("\nDeleting the id %s", id);
        return null;
    }
}
