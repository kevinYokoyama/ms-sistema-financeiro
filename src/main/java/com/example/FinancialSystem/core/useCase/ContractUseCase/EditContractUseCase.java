package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import org.springframework.stereotype.Component;

@Component
public class EditContractUseCase {

    public Contract execute(Contract contract) {
        var contract2 = Contract.builder()
                .id("14")
                .status(ContractStatus.ACTIVE)
                .daysOverdue(10)
                .build();
        contract2.setDaysOverdue(contract.getDaysOverdue());
        System.out.println("Editing the days overdue to " + contract.getDaysOverdue());
        return contract2;
    }
}
