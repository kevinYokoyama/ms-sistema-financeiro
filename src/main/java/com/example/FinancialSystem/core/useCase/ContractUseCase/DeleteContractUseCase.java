package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;

import java.util.List;

public class DeleteContractUseCase {
    public List<Contract> execute(String id){
        System.out.printf("\nDeleting the id %s", id);
        return List.of();
    }
}
