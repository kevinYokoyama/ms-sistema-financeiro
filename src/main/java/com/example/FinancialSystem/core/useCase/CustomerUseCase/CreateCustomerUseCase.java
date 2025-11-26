package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.CustomerStatus;
import com.example.FinancialSystem.core.exception.Customer.CustomerBirthdateNotAllowed;
import com.example.FinancialSystem.core.gateway.CustomerGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateCustomerUseCase {

    private final CustomerGateway customerGateway;

    public Customer execute(Customer customer) throws CustomerBirthdateNotAllowed {

        if (customer.getBirthdate().getYear() < 18) {
            log.error("Customer must be more than eighteen years old");
            throw new CustomerBirthdateNotAllowed();
        }

        customer.setName(customer.getName());
        customer.setDocument("111.222.333-44");
        customer.setBirthdate(customer.getBirthdate());
        customer.setStatus(CustomerStatus.ACTIVE);

        return customerGateway.save(customer);
    }
}
