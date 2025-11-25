package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.exception.Contract.ContractIdNotFoundException;
import com.example.FinancialSystem.core.gateway.ContractGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByIdContractUseCase {

    private final ContractGateway contractGateway;

    public Contract execute(String id) throws ContractIdNotFoundException {

        if (contractGateway.existById(id)) {
            return contractGateway.getById(id);
        }
        throw new ContractIdNotFoundException(id);
    }
}