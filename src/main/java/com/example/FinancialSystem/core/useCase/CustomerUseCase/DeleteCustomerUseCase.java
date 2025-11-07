package com.example.FinancialSystem.core.useCase.CustomerUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DeleteCustomerUseCase {

    public void execute(String id) {

        var contract7 = Contract.builder()
                .id("7")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(6776))
                .startDate(LocalDate.now())
                .build();
        var contract8 = Contract.builder()
                .id("8")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(2468))
                .startDate(LocalDate.now())
                .build();
        var contract9 = Contract.builder()
                .id("9")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(9085))
                .startDate(LocalDate.now())
                .build();

        if (contract7.getId().equals(id)) {
            System.out.print("\nDeleting the id " + contract7.getId());
        }
        if (contract8.getId().equals(id)) {
            System.out.print("\nDeleting the id " + contract8.getId());
        }
        if (contract9.getId().equals(id)) {
            System.out.print("\nDeleting the id " + contract9.getId());
        }
    }
}
