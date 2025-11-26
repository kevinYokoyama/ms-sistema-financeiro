package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.exception.Customer.CustomerIdNotFoundException;
import com.example.FinancialSystem.core.gateway.CustomerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByIdCustomerUseCase {

    private final CustomerGateway customerGateway;

    public Customer execute(String id) throws CustomerIdNotFoundException {

        if (!customerGateway.existById(id)) {
            throw new CustomerIdNotFoundException(id);
        }
        return customerGateway.getById(id);
    }
}