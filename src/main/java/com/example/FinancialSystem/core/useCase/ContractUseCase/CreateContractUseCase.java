package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import com.example.FinancialSystem.core.exception.ContractRequestAmountNotFoundException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class CreateContractUseCase {

    public Contract execute(BigDecimal requestAmount) throws ContractRequestAmountNotFoundException {

        if (requestAmount == null) {
            throw new ContractRequestAmountNotFoundException();
        }

        System.out.print("\nCreating a contract...");
        return Contract.builder()
                .id("1")
                .requestAmount(requestAmount)
                .startDate(LocalDate.now())
                .status(ContractStatus.ACTIVE)
                .build();
    }
}
