package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class CreateContractUseCase {

    public Contract execute(String id, BigDecimal requestAmount) {
        System.out.print("\nCreating a contract...");
        return Contract.builder()
                .id(id)
                .requestAmount(requestAmount)
                .startDate(LocalDate.now())
                .status(ContractStatus.ACTIVE)
                .build();
    }
}
