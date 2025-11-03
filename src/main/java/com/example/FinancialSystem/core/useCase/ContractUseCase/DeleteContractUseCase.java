package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteContractUseCase {
    public List<Contract> execute(String id){
        System.out.printf("\nDeleting the id %s", id);
        return List.of();
    }
}
