package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.Customer;
import org.springframework.stereotype.Component;


@Component
public class CreateContractUseCase {

    public Contract execute(Contract contract) {

        System.out.print("\nCreating a contract...");
        return Contract.builder()
                .customer(Customer.builder().id(contract.getCustomer().getId()).build())
                .operationPeriod(contract.getOperationPeriod())
                .requestAmount(contract.getRequestAmount())
                .build();
    }
}
