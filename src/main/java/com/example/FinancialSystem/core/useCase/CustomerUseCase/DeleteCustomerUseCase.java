package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.exception.Customer.CustomerIdNotFoundException;
import com.example.FinancialSystem.core.gateway.CustomerGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteCustomerUseCase {

    private final CustomerGateway customerGateway;

    public void execute(String id) throws CustomerIdNotFoundException {

        if (!customerGateway.existById(id)){
            log.error("Id not found");
            throw new CustomerIdNotFoundException(id);
        }
        customerGateway.delete(id);
    }
}