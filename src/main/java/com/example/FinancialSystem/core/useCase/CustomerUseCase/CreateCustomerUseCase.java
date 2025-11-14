package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.CustomerStatus;
import com.example.FinancialSystem.core.exception.CustomerStatusNotAllowedException;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerUseCase {

    public Customer execute(Customer customer) throws CustomerStatusNotAllowedException {

        if (!customer.getStatus().equals(CustomerStatus.ACTIVE) && !customer.getStatus().equals(CustomerStatus.BLOCKED) && !customer.getStatus().equals(CustomerStatus.INACTIVE)){
            throw new CustomerStatusNotAllowedException();
        }

//        if (customer.getStatus().equals(null)){
//            throw new CustomerStatusNotAllowedException();
//        }

        System.out.print("\nCreating a customer...");
        return Customer.builder()
                .id(customer.getId())
                .name(customer.getName())
                .birthdate(customer.getBirthdate())
                .status(customer.getStatus())
                .build();
    }
}
