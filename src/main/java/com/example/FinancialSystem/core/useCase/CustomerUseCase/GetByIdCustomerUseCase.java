package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.CustomerStatus;
import com.example.FinancialSystem.core.exception.ContractIdNotFound;
import com.example.FinancialSystem.core.exception.CustomerIdNotFound;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GetByIdCustomerUseCase {

    public Customer execute(String id) throws CustomerIdNotFound {

        var customer1 = Customer.builder()
                .id("1")
                .name("Kevin")
                .birthdate(LocalDate.of(2009, 5, 9))
                .status(CustomerStatus.ACTIVE)
                .build();
        var customer2 = Customer.builder()
                .id("2")
                .name("Gabriel")
                .birthdate(LocalDate.of(2010, 3, 23))
                .status(CustomerStatus.ACTIVE)
                .build();
        var customer3 = Customer.builder()
                .id("3")
                .name("Yokoyama")
                .birthdate(LocalDate.of(2009, 1, 3))
                .status(CustomerStatus.ACTIVE)
                .build();

        if (!customer1.getId().equals(id) && !customer2.getId().equals(id) && !customer3.getId().equals(id)) {
            throw new CustomerIdNotFound();
        }

        if (customer1.getId().equals(id)) {
            return customer1;
        }
        if (customer2.getId().equals(id)) {
            return customer2;
        }
        if (customer3.getId().equals(id)) {
            return customer3;
        }
        return null;
    }
}
