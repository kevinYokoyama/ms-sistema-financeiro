package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import org.springframework.stereotype.Component;

@Component
public class DeleteContractUseCase {

    public Contract execute(String id) {
        System.out.printf("\nDeleting the id %s", id);
        return null;
    }
}
