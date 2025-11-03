package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.CustomerStatus;
import org.springframework.stereotype.Component;

@Component
public class EditCustomerUseCase {
    public Customer execute(Customer customer) {
        var customer2 = Customer.builder()
                .id("149")
                .name("Naomi")
                .status(CustomerStatus.ACTIVE)
                .build();
        System.out.println(customer2);
        System.out.println("Editing the name");
        customer2.setName(customer.getName());
        return customer2;
    }
}
