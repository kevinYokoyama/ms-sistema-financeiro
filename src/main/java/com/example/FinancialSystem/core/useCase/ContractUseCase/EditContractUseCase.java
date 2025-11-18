package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import com.example.FinancialSystem.core.exception.Contract.ContractRequestAmountNotAllowedException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EditContractUseCase {

    public Contract execute(Contract contract) throws ContractRequestAmountNotAllowedException {

        var contract2 = Contract.builder()
                .customer(Customer.builder().id(contract.getCustomer().getId()).build())
                .operationPeriod(contract.getOperationPeriod())
                .status(ContractStatus.ACTIVE)
                .daysOverdue(10)
                .requestAmount(BigDecimal.valueOf(10000))
                .build();

        if (contract.getRequestAmount().compareTo(BigDecimal.valueOf(500)) < 0) {
            throw new ContractRequestAmountNotAllowedException();
        }
        contract2.setRequestAmount(contract.getRequestAmount());
        System.out.println("Editing the requested amount to " + contract.getRequestAmount());
        return contract2;
    }
}
