package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.exception.Contract.ContractIdNotFoundException;
import com.example.FinancialSystem.core.gateway.ContractGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteContractUseCase {

    private final ContractGateway contractGateway;

    public void execute(String id) throws ContractIdNotFoundException {

        if (contractGateway.existById(id)) {
            System.out.printf("Id %s removed successfully", id);
            contractGateway.delete(id);
        }
        throw new ContractIdNotFoundException(id);
    }
}