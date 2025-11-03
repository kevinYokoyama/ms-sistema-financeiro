package com.example.FinancialSystem.core.useCase.ContractUseCase;

import org.springframework.stereotype.Component;

@Component
public class DeleteContractUseCase {

    public void execute(String id) {
        System.out.printf("\nDeleting the id %s", id);
    }
}
