package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DeletePaymentUseCase {

    public void execute(String id) {

        var contract10 = Contract.builder()
                .id("10")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(2245))
                .startDate(LocalDate.now())
                .build();
        var contract11 = Contract.builder()
                .id("11")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(24785))
                .startDate(LocalDate.now())
                .build();
        var contract12 = Contract.builder()
                .id("12")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(8753))
                .startDate(LocalDate.now())
                .build();

        if (contract10.getId().equals(id)) {
            System.out.print("\nDeleting the id " + contract10.getId());
        }
        if (contract11.getId().equals(id)) {
            System.out.print("\nDeleting the id " + contract11.getId());
        }
        if (contract12.getId().equals(id)) {
            System.out.print("\nDeleting the id " + contract12.getId());
        }
    }
}
