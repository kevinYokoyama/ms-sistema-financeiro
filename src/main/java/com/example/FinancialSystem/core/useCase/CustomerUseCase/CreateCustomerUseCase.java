package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.CustomerStatus;
import com.example.FinancialSystem.core.gateway.CustomerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCustomerUseCase {

    private final CustomerGateway customerGateway;

    public Customer execute(Customer customer) {

        customer.setName(customer.getName());
        customer.setDocument("111.222.333-44");
        customer.setBirthdate(customer.getBirthdate());
        customer.setStatus(CustomerStatus.ACTIVE);
        System.out.print("\nCreating a customer...");

        return customerGateway.save(customer);
    }
}
