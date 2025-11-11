package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import com.example.FinancialSystem.core.exception.ContractIdNotFoundException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DeleteContractUseCase {

    public void execute(String id) throws ContractIdNotFoundException {

        var contract4 = Contract.builder()
                .id("4")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(5000))
                .startDate(LocalDate.now())
                .build();
        var contract5 = Contract.builder()
                .id("5")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(1200))
                .startDate(LocalDate.now())
                .build();
        var contract6 = Contract.builder()
                .id("6")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(149149))
                .startDate(LocalDate.now())
                .build();

        if (!contract4.getId().equals(id) && !contract5.getId().equals(id) && !contract6.getId().equals(id)) {
            throw new ContractIdNotFoundException(id);
        }
        if (contract4.getId().equals(id)) {
            System.out.print("\nDeleting the id " + contract4.getId());
        }
        if (contract5.getId().equals(id)) {
            System.out.print("\nDeleting the id " + contract5.getId());
        }
        if (contract6.getId().equals(id)) {
            System.out.print("\nDeleting the id " + contract6.getId());
        }
    }
}
