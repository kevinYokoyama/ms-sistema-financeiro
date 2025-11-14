package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.CustomerStatus;
import com.example.FinancialSystem.core.exception.CustomerIdNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DeleteCustomerUseCase {

    public void execute(String id) throws CustomerIdNotFoundException {

        var customer1 = Customer.builder()
                .id("1")
                .name("Yokoyama")
                .status(CustomerStatus.ACTIVE)
                .birthdate(LocalDate.of(2009, 1, 3))
                .build();
        var customer2 = Customer.builder()
                .id("2")
                .name("Kevin")
                .status(CustomerStatus.ACTIVE)
                .birthdate(LocalDate.of(2009, 5, 9))
                .build();
        var customer3 = Customer.builder()
                .id("3")
                .name("Taku")
                .status(CustomerStatus.ACTIVE)
                .birthdate(LocalDate.of(1990, 7, 23))
                .build();

        if (!customer1.getId().equals(id) && !customer2.getId().equals(id) && !customer3.getId().equals(id)) {
            throw new CustomerIdNotFoundException(id);
        }

        if (customer1.getId().equals(id)) {
            System.out.print("\nDeleting the id " + customer1.getId());
        }
        if (customer2.getId().equals(id)) {
            System.out.print("\nDeleting the id " + customer2.getId());
        }
        if (customer3.getId().equals(id)) {
            System.out.print("\nDeleting the id " + customer3.getId());
        }
    }
}
