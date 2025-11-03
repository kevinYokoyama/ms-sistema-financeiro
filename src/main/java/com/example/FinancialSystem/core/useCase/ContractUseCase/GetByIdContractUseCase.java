package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class GetByIdContractUseCase {
    @Bean
    public Contract execute(String id){
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

        if (contract1.getId().equals(id)) {
            return contract1;
        }
        else if (contract2.getId().equals(id)) {
            return contract2;
        }
        else if (contract3.getId().equals(id)) {
            return contract3;
        }
        return null;
    }
}
