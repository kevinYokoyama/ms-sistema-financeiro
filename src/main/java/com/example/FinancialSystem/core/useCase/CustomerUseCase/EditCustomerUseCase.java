package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.exception.Customer.CustomerIdNotFoundException;
import com.example.FinancialSystem.core.exception.Customer.CustomerNameNotAllowedException;
import com.example.FinancialSystem.core.gateway.GenericGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EditCustomerUseCase {

    private final GenericGateway<Customer> customerGateway;

    private final GetByIdCustomerUseCase getByIdCustomerUseCase;

    public Customer execute(String id, Customer customer) throws CustomerNameNotAllowedException, CustomerIdNotFoundException {

        var saved = getByIdCustomerUseCase.execute(id);
        if (customer.getName().equals(saved.getName())){
            log.error("You can't change the same name as it already was");
            throw new CustomerNameNotAllowedException(customer.getName());
        }

        saved.setName(customer.getName());

        return customerGateway.save(saved);
    }
}
