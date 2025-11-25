package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.exception.Customer.CustomerIdNotFoundException;
import com.example.FinancialSystem.core.gateway.CustomerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCustomerUseCase {

    private final CustomerGateway customerGateway;

    public void execute(String id) throws CustomerIdNotFoundException {

        if (customerGateway.existById(id)){
            System.out.printf("Id %s removed successfully", id);
            customerGateway.delete(id);
        }
        throw new CustomerIdNotFoundException(id);
    }
}