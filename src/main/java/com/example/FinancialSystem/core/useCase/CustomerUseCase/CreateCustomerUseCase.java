package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.CustomerStatus;
import com.example.FinancialSystem.core.exception.Customer.CustomerBirthdateNotAllowed;
import com.example.FinancialSystem.core.exception.Customer.CustomerZipCodeNotFoundException;
import com.example.FinancialSystem.core.gateway.GenericGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateCustomerUseCase {

    private final GenericGateway<Customer> customerGateway;

    public Customer execute(Customer customer) throws CustomerBirthdateNotAllowed, CustomerZipCodeNotFoundException {

        if (customer.getBirthdate().getYear() < 18) {
            log.error("Customer must be more than eighteen years old");
            throw new CustomerBirthdateNotAllowed();
        }

        if (customer.getZipcode() == null) {
            log.error("Zipcode not found");
            throw new CustomerZipCodeNotFoundException(customer.getZipcode());
        }

        customer.setName(customer.getName());
        customer.setDocument(customer.getDocument());
        customer.setBirthdate(customer.getBirthdate());
        customer.setStatus(CustomerStatus.ACTIVE);

        return customerGateway.save(customer);
    }
}
