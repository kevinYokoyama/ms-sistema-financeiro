package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.CustomerStatus;

public class CreateCustomerUseCase {
    public Customer execute(Customer customer) {
        System.out.print("\nCreating a customer...");
        return Customer.builder()
                .id(customer.getId())
                .name(customer.getName())
                .birthdate(customer.getBirthdate())
                .status(CustomerStatus.ACTIVE)
                .build();
    }
}
