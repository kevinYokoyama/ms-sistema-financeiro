package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.exception.Customer.CustomerNameNotAllowedException;
import com.example.FinancialSystem.core.gateway.CustomerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditCustomerUseCase {

    private final CustomerGateway customerGateway;

    public Customer execute(Customer customer) throws CustomerNameNotAllowedException {

        Customer editedCustomer = customerGateway.getById(customer.getId());

        if (customer.getName().equals(editedCustomer.getName())){
            throw new CustomerNameNotAllowedException(customer.getName());
        }

        editedCustomer.setName(customer.getName());
        System.out.printf("\nEditing the name to %s", editedCustomer.getName());

        return editedCustomer;
    }
}
