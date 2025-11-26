package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.exception.Customer.CustomerIdNotFoundException;
import com.example.FinancialSystem.core.exception.Customer.CustomerNameNotAllowedException;
import com.example.FinancialSystem.core.gateway.CustomerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditCustomerUseCase {

    private final CustomerGateway customerGateway;

    private final GetByIdCustomerUseCase getByIdCustomerUseCase;

    public Customer execute(String id, Customer customer) throws CustomerNameNotAllowedException, CustomerIdNotFoundException {

        var saved = getByIdCustomerUseCase.execute(id);
        if (customer.getName().equals(saved.getName())){
            throw new CustomerNameNotAllowedException(customer.getName());
        }

        saved.setName(customer.getName());
        System.out.printf("\nEditing the name to %s", saved.getName());

        return customerGateway.save(saved);
    }
}
