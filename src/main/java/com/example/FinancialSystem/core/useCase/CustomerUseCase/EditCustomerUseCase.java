package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.CustomerStatus;
import com.example.FinancialSystem.core.exception.CustomerNameNotAllowedException;
import org.springframework.stereotype.Component;

@Component
public class EditCustomerUseCase {

    public Customer execute(Customer customer) throws CustomerNameNotAllowedException {
        var customer2 = Customer.builder()
                .id("149")
                .name("Naomi")
                .status(CustomerStatus.ACTIVE)
                .build();

        if (customer2.getName().equals(customer.getName())){
            throw new CustomerNameNotAllowedException();
        }

        customer2.setName(customer.getName());
        System.out.printf("\nEditing the name to %s", customer2.getName());
        return customer2;
    }
}
