package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.exception.ContractIdNotFound;
import org.springframework.stereotype.Component;

@Component
public class DeleteContractUseCase {

    public void execute(String id) throws ContractIdNotFound {

        if (id == null) {
            throw new ContractIdNotFound();
        }
        System.out.printf("\nDeleting the id %s", id);
    }
}
