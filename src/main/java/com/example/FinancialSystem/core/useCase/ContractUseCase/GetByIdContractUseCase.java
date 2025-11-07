package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import com.example.FinancialSystem.core.exception.ContractIdNotFound;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class GetByIdContractUseCase {

    public Contract execute(String id) throws ContractIdNotFound {
        var contract1 = Contract.builder()
                .id("1")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(1000))
                .startDate(LocalDate.now())
                .build();
        var contract2 = Contract.builder()
                .id("2")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(2000))
                .startDate(LocalDate.now())
                .build();
        var contract3 = Contract.builder()
                .id("3")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(3000))
                .startDate(LocalDate.now())
                .build();

        if (!contract1.getId().equals(id) && !contract2.getId().equals(id) && !contract3.getId().equals(id)) {
            throw new ContractIdNotFound();
        }

        if (contract1.getId().equals(id)) {
            return contract1;
        }
        if (contract2.getId().equals(id)) {
            return contract2;
        }
        if (contract3.getId().equals(id)) {
            return contract3;
        }
        return null;
    }
}
